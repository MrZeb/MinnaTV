package se.zeb.minnatv.models.remote

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Credits(

        @field:SerializedName("actor")
	val actor: List<ActorItem?>? = null,

        @field:SerializedName("director")
	val director: List<DirectorItem?>? = null
)