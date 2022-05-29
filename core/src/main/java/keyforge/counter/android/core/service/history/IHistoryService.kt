package keyforge.counter.android.core.service.history

import keyforge.counter.android.core.model.BaseResponse
import keyforge.counter.android.core.model.History
import keyforge.counter.android.core.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface IHistoryService {
    fun putHistory(history: History): Flow<Resource<BaseResponse>>
}