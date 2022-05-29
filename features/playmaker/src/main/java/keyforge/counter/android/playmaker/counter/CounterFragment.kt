package keyforge.counter.android.playmaker.counter

import android.util.Log
import org.koin.androidx.viewmodel.ext.android.viewModel
import keyforge.counter.android.commons.BaseFragment
import keyforge.counter.android.playmaker.R
import keyforge.counter.android.playmaker.databinding.FragmentCounterBinding

class CounterFragment : BaseFragment<FragmentCounterBinding>(R.layout.fragment_counter) {

    private val viewModel: CounterViewModel by viewModel()

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel

        viewBinding.btnInsert.setOnClickListener {
            viewModel.insertHistory()
        }

        viewModel.status.observe(viewLifecycleOwner) { status ->
            Log.d("bindingStaus", "onInitDataBinding: $status")
        }
    }

}