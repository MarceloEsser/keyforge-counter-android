package keyforge.counter.android.core.service.history

import android.content.Context
import keyforge.counter.android.core.DataBoundResource
import keyforge.counter.android.core.model.BaseResponse
import keyforge.counter.android.core.model.History
import keyforge.counter.android.core.helper.WorkScheduler
import keyforge.counter.android.core.wrapper.Resource
import kotlinx.coroutines.flow.Flow

class HistoryServiceImpl(
    private val api: IHistoryApi,
    private val workScheduler: WorkScheduler
) : IHistoryService {

    override fun putHistory(history: History): Flow<Resource<BaseResponse>> {
        return DataBoundResource(
            shouldFetch = { false },
            createCall = {
                return@DataBoundResource api.putHistory(history)
            },
        ).build()
    }
}