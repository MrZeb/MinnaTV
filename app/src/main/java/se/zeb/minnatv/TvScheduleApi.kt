package se.zeb.minnatv

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import se.zeb.minnatv.models.TvChannel
import java.text.SimpleDateFormat
import java.util.*


/**
 * Forza Football
 * <p>
 * Created by Sebastian Fürle on 2018-01-14
 * <p>
 * Copyright © 2018 FootballAddicts. All rights reserved.
 */

class TvScheduleApi {

    private var service: TvScheduleService

    init {
        val okHttpClientBuilder = OkHttpClient().newBuilder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        okHttpClientBuilder.addInterceptor(logging)
        val client = okHttpClientBuilder.build()

        val retrofit = Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .build()

        service = retrofit.create(TvScheduleService::class.java)
    }


    fun getSchedulesToday(channel: TvChannel): Call<TvScheduleResponse> {
        val today = Date()
        val calendar = Calendar.getInstance()
        calendar.time = today

        var dateString = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(calendar.time)

        return service.getSchedules(channel.remoteName, dateString)
    }

    fun getBaseUrl(): String {
        return "http://json.xmltv.se"
    }
}