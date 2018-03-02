package se.zeb.minnatv

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Forza Football
 * <p>
 * Created by Sebastian Fürle on 2018-01-14
 * <p>
 * Copyright © 2018 FootballAddicts. All rights reserved.
 */

interface TvScheduleService {
    @GET("/{channel}_{date}.js.gz")
    fun getTv3Schedules(@Path("channel") channel: String, @Path("date") date: String)
            : Call<TvScheduleResponse>
}