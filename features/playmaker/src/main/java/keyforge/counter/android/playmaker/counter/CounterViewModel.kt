package keyforge.counter.android.playmaker.counter

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import keyforge.counter.android.core.model.Chain
import keyforge.counter.android.core.model.KeyForge
import keyforge.counter.android.core.model.key.BlueKey
import keyforge.counter.android.core.model.key.RedKey
import keyforge.counter.android.core.model.key.YellowKey

class CounterViewModel(
//    private val api: IHistoryService,
//    private val workScheduler: WorkScheduler,
//    private val dispatcher: CoroutineDispatcher
) : ViewModel() {


    private var amberCounter: MutableLiveData<Int> = MutableLiveData<Int>(0)
    private var totalAmberToForge: MutableLiveData<Int> = MutableLiveData<Int>(4)
    private var chain = MutableLiveData(Chain(0))
    private var blueKey = MutableLiveData(BlueKey(false, 0))
    private var yellowKey = MutableLiveData(YellowKey(false, 0))
    private var redKey = MutableLiveData(RedKey(false, 0))


    val keyForgeMediator: MutableLiveData<KeyForge> = MediatorLiveData<KeyForge>().apply {
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

    fun increaseChain(counter: Int = 1) {
        chain.value?.let {
            it.current.plus(counter)
            chain.postValue(it)
        }
    }

    fun decreaseChain(counter: Int = 1) {
        chain.value?.let {
            if (it.current >= counter) {
                it.current.minus(counter)
            }
        }
    }
}