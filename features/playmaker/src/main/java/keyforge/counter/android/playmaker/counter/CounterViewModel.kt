package keyforge.counter.android.playmaker.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import keyforge.counter.android.core.Status
import keyforge.counter.android.core.helper.WorkScheduler
import keyforge.counter.android.core.model.BaseResponse
import keyforge.counter.android.core.model.History
import keyforge.counter.android.core.model.MatchUp
import keyforge.counter.android.core.service.history.HistoryServiceImpl
import keyforge.counter.android.core.service.history.IHistoryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.*

class CounterViewModel(
    private val api: IHistoryService,
    private val workScheduler: WorkScheduler,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> by lazy {
        insertHistory()
        _status
    }

    private val _response = MutableLiveData<BaseResponse>()
    val response: LiveData<BaseResponse>
        get() = _response

    fun insertHistory() {
        viewModelScope.launch(dispatcher) {

            val now: Long = Calendar.getInstance().timeInMillis
            val history = History(
                date = now,
                userId = "marselou",
                matchUp = MatchUp(
                    6,
                    false,
                    true,
                    false,
                    false
                )
            )
            api.putHistory(
                history
            ).collect {
                it.data?.let { baseResponse ->
                    _response.postValue(baseResponse)
                }
                _status.postValue(it.status)
            }
        }

    }
}