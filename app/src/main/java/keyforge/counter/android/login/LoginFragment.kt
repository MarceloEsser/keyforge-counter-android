package keyforge.counter.android.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import keyforge.counter.android.R
import androidx.navigation.fragment.findNavController
import keyforge.counter.android.commons.BaseFragment
import keyforge.counter.android.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>(
    R.layout.fragment_login
) {

    private val viewModel: LoginViewModel by viewModel()
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
    }

    override fun onInitDataBinding() {
        viewBinding.fragment = this
        viewBinding.viewModel = viewModel

        viewBinding.btnDoLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                viewBinding.etLogin.text.toString(),
                viewBinding.etPassword.text.toString()
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                } else {
                    //TODO: Auth failed
                }
            }
        }

        viewBinding.brnCurrentUser.setOnClickListener {
//            findNavController().navigate(
//                LoginFragmentDirections.goToFragmentCounter()
//            )
        }
    }

    private fun createAccount() {
        auth.createUserWithEmailAndPassword(
            viewBinding.etLogin.text.toString(),
            viewBinding.etPassword.text.toString()
        )
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("success", "createUserWithEmail:success")
                    val user = auth.currentUser
//                    updateUI(user)
                } else {
                    Log.w("exception", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        requireCompatActivity(), "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
//                    updateUI(null)
                }
            }
    }
}