package keyforge.counter.android.core.model

import com.google.gson.annotations.SerializedName

class MatchUp(
    @SerializedName("amberQuantityUsedToForge")
    val amberQuantityUsedToForge: Int,

    @SerializedName("isRedKeyForged")
    val isRedKeyForged: Boolean,

    @SerializedName("isYellowKeyForged")
    val isYellowKeyForged: Boolean,

    @SerializedName("isBlueKeyForged")
    val isBlueKeyForged: Boolean,

    @SerializedName("isWinner")
    val isWinner: Boolean,
)