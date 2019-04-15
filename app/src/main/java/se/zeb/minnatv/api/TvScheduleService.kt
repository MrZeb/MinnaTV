package se.zeb.minnatv.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import se.zeb.minnatv.TvScheduleResponse


/**
 * Forza Football
 * <p>
 * Created by Sebastian Fürle on 2018-01-14
 * <p>
 * Copyright © 2018 FootballAddicts. All rights reserved.
 */

interface TvScheduleService {
    @GET("/{channel}_{date}.js.gz")
    fun getSchedules(@Path("channel") channel: String, @Path("date") date: String)
            : Call<TvScheduleResponse>
}