package se.zeb.minnatv

import android.arch.lifecycle.*
import android.util.Log
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import se.zeb.minnatv.models.FavoriteShow
import se.zeb.minnatv.models.FavoriteShowType
import se.zeb.minnatv.models.TvChannel
import se.zeb.minnatv.models.remote.Jsontv
import se.zeb.minnatv.models.remote.ProgrammeItem
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Forza Football
 * <p>
 * Created by Sebastian Fürle on 2018-01-14
 * <p>
 * Copyright © 2018 FootballAddicts. All rights reserved.
 */
class TvScheduleViewModel : ViewModel(), LifecycleObserver {

    val tvSchedules: MutableLiveData<List<FavoriteShow>>

    private val tag = "viewmodel"

    private val cacheShows: ArrayList<FavoriteShow> = ArrayList()

    private var nbrResponses: Int = 0

    init {
        Log.d(tag, "init")
        tvSchedules = MutableLiveData()

        TvChannel.values()
                .map { Log.d("call", it.toString()) ; TvScheduleApi().getSchedulesToday(it) }
                .forEach { callAsync ->
                    callAsync.enqueue(object : Callback<TvScheduleResponse> {
                        override fun onResponse(call: Call<TvScheduleResponse>, response: Response<TvScheduleResponse>) {
                            val tvSchedulesResponse = response.body()

                            val favoriteShowModels = ArrayList<FavoriteShow>()

                            if (tvSchedulesResponse?.jsontv?.programme != null) {
                                for (programme: ProgrammeItem? in tvSchedulesResponse.jsontv.programme) {
                                    FavoriteShowType.values()
                                            .filter { programme?.title?.sv.equals(it.title, true) }
                                            .filter { Date().before(programme?.stop?.toLong()?.let { getDate(it) }) }
                                            .forEach {
                                                if (programme != null) {
                                                    if (programme.title?.sv != null && programme.channel != null && programme.start != null && programme.stop != null) {
                                                        Log.d("TV programme", "Fav: " + programme?.title?.sv + " start: " + getDate(programme.start.toLong()) + " stop: " + getDate(programme.stop.toLong()))
                                                        favoriteShowModels.add(FavoriteShow(programme.title.sv, getTvChannel(programme.channel), getDate(programme.start.toLong()), getDate(programme.stop.toLong())))
                                                    }
                                                }
                                            }
                                }
                            }

                            cacheShows.addAll(favoriteShowModels)
                            nbrResponses += 1

                            Log.d("responze", nbrResponses.toString())

                            if (nbrResponses == TvChannel.values().size) {
                                tvSchedules.postValue(cacheShows)
                            }
                        }

                        override fun onFailure(call: Call<TvScheduleResponse>, throwable: Throwable) {
                            println(throwable)

                            Log.d("responze", "fail: " + throwable.toString() + " " + nbrResponses.toString())

                            nbrResponses = nbrResponses++
                        }
                    })
                }

    }

    private fun getTvChannel(channel: String): TvChannel {
        return TvChannel.fromRemote(channel)
    }

    fun getDate(dateMs: Long): Date {
        return dateMs?.let { Date(TimeUnit.SECONDS.toMillis(it)) }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        Log.d(tag, "Resume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun any() {
        Log.d(tag, "Lifecycle event happened")
    }
}

data class TvScheduleResponse(

        @field:SerializedName("jsontv")
        val jsontv: Jsontv? = null
)
