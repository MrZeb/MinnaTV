package se.zeb.minnatv.models.remote

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ProgrammeItem(

        @field:SerializedName("date")
        val date: String? = null,

        @field:SerializedName("country")
        val country: List<String?>? = null,

        @field:SerializedName("new")
        val jsonMemberNew: String? = null,

        @field:SerializedName("episodeNum")
        val episodeNum: EpisodeNum? = null,

        @field:SerializedName("channel")
        val channel: String? = null,

        @field:SerializedName("start")
        val start: String? = null,

        @field:SerializedName("rating")
        val rating: Rating? = null,

        @field:SerializedName("video")
        val video: Video? = null,

        @field:SerializedName("title")
        val title: Title? = null,

        @field:SerializedName("url")
        val url: List<String?>? = null,

        @field:SerializedName("stop")
        val stop: String? = null,

        @field:SerializedName("credits")
        val credits: Credits? = null,

        @field:SerializedName("category")
        val category: Category? = null,

        @field:SerializedName("desc")
        val desc: Desc? = null
)