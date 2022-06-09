package keyforge.counter.android.playmaker.counterViewModel

import keyforge.counter.android.playmaker.BaseUnitTest
import keyforge.counter.android.playmaker.counter.CounterViewModel
import org.junit.Before
import org.junit.Test

class TotalAmberToForgeAKeyTest : BaseUnitTest() {

    private lateinit var viewModel: CounterViewModel

    @Before
    fun init() {
        viewModel = CounterViewModel()
    }

    @Test
    fun `Should be equal to four when the viewModel init`() {
        viewModel.keyForgeMediator.observeForever {
            assert(it.totalAmberToForgeKey == 4)
        }
    }

    @Test
    fun `Should be possible to forge a key when amber counter is higher or equal to totamAmberToForgeAKey`() {
        viewModel.increaseAmberCounter(4)

        viewModel.keyForgeMediator.observeForever {
            assert(it.canForge())
        }
    }

    @Test
    fun `Shouldn't be possible to forge a key when amber counter is lower than totalAmberToForgeAKey`() {
        viewModel.increaseAmberCounter(3)

        viewModel.keyForgeMediator.observeForever {
            assert(it.totalAmberToForgeKey == 4)
            assert(it.amberCounter == 3)
            assert(!it.canForge())
        }
    }
}