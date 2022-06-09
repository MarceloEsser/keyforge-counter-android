package keyforge.counter.android.playmaker.counterViewModel

import keyforge.counter.android.playmaker.BaseUnitTest
import keyforge.counter.android.playmaker.counter.CounterViewModel
import org.junit.Before
import org.junit.Test

class AmberCounterTest : BaseUnitTest() {

    private lateinit var viewModel: CounterViewModel

    @Before
    fun init() {
        viewModel = CounterViewModel()
    }

    @Test
    fun `Should notify and increase amber counter on keyForge liveData when increase amberCounter`() {
        viewModel.increaseAmberCounter(1)

        viewModel.matchUpMediator.observeForever {
            assert(it.amberCounter == 1)
        }
    }

    @Test
    fun `Should notify and decrease amber counter from keyForge`() {
        viewModel.increaseAmberCounter(5)
        viewModel.decreaseAmberCounter()

        viewModel.matchUpMediator.observeForever {
            assert(it.amberCounter == 4)
        }
    }

    @Test
    fun `Should notify and do not decrease counter if amberCounter is equal to zero`() {
        viewModel.decreaseAmberCounter()

        viewModel.matchUpMediator.observeForever {
            assert(it.amberCounter == 0)
        }
    }
}