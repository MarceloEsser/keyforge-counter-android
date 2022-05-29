package keyforge.counter.android.core.model

class BaseResponse(
    val message: String,
    val code: String,
    val status: Int,
    val data: Any?
)