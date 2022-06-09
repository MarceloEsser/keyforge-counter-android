package keyforge.counter.android.playmaker.counterViewModel

import keyforge.counter.android.playmaker.BaseUnitTest
import keyforge.counter.android.playmaker.counter.CounterViewModel
import org.junit.Before
import org.junit.Test

class ChainTest : BaseUnitTest() {

    private lateinit var viewModel: CounterViewModel

    @Before
    fun init() {
        viewModel = CounterViewModel()
    }

    @Test
    fun `Should notify the mediator when increase chain`() {
        viewModel.increaseChain()
        viewModel.keyForgeMediator.observeForever {
            it.chain?.current = 1
        }
    }

    @Test
    fun `Should notify the mediator when decrease chain`() {
        viewModel.increaseChain(4)
        viewModel.decreaseChain()
        viewModel.keyForgeMediator.observeForever {
            it.chain?.current = 3
        }
    }
}