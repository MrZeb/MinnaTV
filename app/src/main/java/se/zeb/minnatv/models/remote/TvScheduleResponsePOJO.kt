package se.zeb.minnatv.models.remote

import com.google.gson.annotations.SerializedName

data class TvScheduleResponsePOJO(

        @field:SerializedName("jsontv")
        val jsontv: Jsontv? = null
)