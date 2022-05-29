package keyforge.counter.android.core.model

import com.google.gson.annotations.SerializedName

class History(
    @SerializedName("id")
    val id: Long,
    @SerializedName("date")
    val date: Int,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("matchUp")
    val matchUp: MatchUp,
)