package keyforge.counter.android.playmaker.counter

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.*
import keyforge.counter.android.core.Status
import keyforge.counter.android.core.helper.WorkScheduler
import keyforge.counter.android.core.model.*
import keyforge.counter.android.core.model.key.BlueKey
import keyforge.counter.android.core.model.key.RedKey
import keyforge.counter.android.core.model.key.YellowKey
import keyforge.counter.android.core.service.history.HistoryServiceImpl
import keyforge.counter.android.core.service.history.IHistoryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.*

class CounterViewModel(
//    private val api: IHistoryService,
//    private val workScheduler: WorkScheduler,
//    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private var amberCounter: MutableLiveData<Int> = MutableLiveData<Int>(0)
    private var totalAmberToForge: MutableLiveData<Int> = MutableLiveData<Int>(4)
    private var chain = MutableLiveData<Chain>()
    private var blueKey = MutableLiveData<BlueKey>()
    private var yellowKey = MutableLiveData<YellowKey>()
    private var redKey = MutableLiveData<RedKey>()


    val matchUpMediator: MutableLiveData<KeyForge> = MediatorLiveData<KeyForge>().apply {
        if (value == null) {
            postValue(
                KeyForge(4)
            )
        }
        addSource(amberCounter) {
            value?.amberCounter = it
        }
        addSource(totalAmberToForge) {
            value?.totalAmberToForgeKey = it
        }
        addSource(chain) {
            value?.chain = it
        }
        addSource(blueKey) {
            value?.blueKey = it
        }
        addSource(yellowKey) {
            value?.yellowKey = it
        }
        addSource(redKey) {
            value?.redKey = it
        }
    }


    fun increaseAmberCounter(counter: Int = 1) {
        amberCounter.postValue(amberCounter.value?.plus(counter))
    }

    fun decreaseAmberCounter(counter: Int = 1) {
        amberCounter.value?.let {
            if (it >= counter)
                amberCounter.postValue(amberCounter.value?.minus(counter))
        }
    }
}