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
            assert(it.chain != null)
            assert(it.chain?.current == 1)
        }

    }

    @Test
    fun `Should notify the mediator when decrease chain`() {
        viewModel.increaseChain(4)
        viewModel.decreaseChain()
        viewModel.keyForgeMediator.observeForever {
            assert(it.chain != null)
            assert(it.chain?.current == 3)
        }
    }

    @Test
    fun `Shouldn't be possible to have a chain less tan zero`() {
        viewModel.increaseChain(5)
        viewModel.decreaseChain(6)
        viewModel.keyForgeMediator.observeForever {
            assert(it.chain != null)
            assert(it.chain?.current == 0)
        }
    }

    @Test
    fun `Should accept negative numbers when decrease chain`() {
        viewModel.increaseChain(10)
        viewModel.decreaseChain(-8)
        viewModel.keyForgeMediator.observeForever {
            assert(it.chain != null)
            assert(it.chain?.current == 2)
        }
    }

    @Test
    fun `Should have a punishment equal to minus one when the chain is in one and six`() {
        viewModel.increaseChain(6)
        viewModel.keyForgeMediator.observeForever {
            assert(it.chain?.current == 6)
            assert(it.chain?.getPunishment() == -1)
        }
    }

    @Test
    fun `Should have a punishment equal to minus two when the chain is in seven and twelve`() {
        viewModel.increaseChain(8)
        viewModel.keyForgeMediator.observeForever {
            assert(it.chain?.current == 8)
            assert(it.chain?.getPunishment() == -2)
        }
    }

    @Test
    fun `Should have a punishment equal to minus three when the value is in thirteen and eighteen`() {
        viewModel.increaseChain(15)
        viewModel.keyForgeMediator.observeForever {
            assert(it.chain?.current == 15)
            assert(it.chain?.getPunishment() == -3)
        }
    }

    @Test
    fun `Should have a punishment equal to minus four when the chain is higher than eighteen`() {
        viewModel.increaseChain(19)
        viewModel.keyForgeMediator.observeForever {
            assert(it.chain?.current == 19)
            assert(it.chain?.getPunishment() == -4)
        }
    }

    @Test
    fun `Shouldn't have a punishment when the chain is equal to zero`() {
        viewModel.increaseChain(0)
        viewModel.keyForgeMediator.observeForever {
            assert(it.chain?.current == 0)
            assert(it.chain?.getPunishment() == 0)
        }
    }
}