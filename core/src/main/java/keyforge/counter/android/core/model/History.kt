package keyforge.counter.android.core.model

import com.google.gson.annotations.SerializedName

class History(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("date")
    val date: Long,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("matchUp")
    val matchUp: MatchUp,
)