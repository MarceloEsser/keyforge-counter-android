package keyforge.counter.android.commons

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import keyforge.counter.android.commons.widgets.LoaderDialog

abstract class BaseFragment<B : ViewDataBinding>(
    @LayoutRes
    private val layoutId: Int
) : Fragment() {

    private val loader: LoaderDialog = LoaderDialog()
    lateinit var viewBinding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitDataBinding()
    }

    fun requireCompatActivity(): AppCompatActivity {
        requireActivity()
        val activity = requireActivity()
        if (activity is AppCompatActivity) {
            return activity
        } else {
            throw TypeCastException("Main activity should extend from 'AppCompatActivity'")
        }
    }

    fun showSnackBar(message: String) {
        Snackbar.make(
            requireCompatActivity().findViewById(android.R.id.content), message,
            Snackbar.LENGTH_SHORT
        ).setBackgroundTint(Color.BLACK).setTextColor(Color.WHITE).show()
    }

    fun showLoader() {
        if (!loader.isAdded) {
            loader.show(requireCompatActivity().supportFragmentManager, "loaderTag")
        }
    }

    fun hideLoader() {
        if (loader.isAdded) {
            loader.dismiss()
        }
    }

    abstract fun onInitDataBinding()
}