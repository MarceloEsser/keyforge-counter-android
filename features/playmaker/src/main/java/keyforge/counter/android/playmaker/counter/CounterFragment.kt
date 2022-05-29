package keyforge.counter.android.playmaker.counter

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import keyforge.counter.android.playmaker.R

class CounterFragment : Fragment() {

    companion object {
        fun newInstance() = CounterFragment()
    }

    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}