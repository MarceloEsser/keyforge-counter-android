package keyforge.counter.android.core.service.history

import keyforge.counter.android.core.model.BaseResponse
import keyforge.counter.android.core.model.History
import keyforge.counter.android.core.wrapper.Resource
import retrofit2.http.Body
import retrofit2.http.PUT

interface IHistoryApi {

    @PUT("/history")
    suspend fun putHistory(
        @Body body: History
    ): Resource<BaseResponse>
}