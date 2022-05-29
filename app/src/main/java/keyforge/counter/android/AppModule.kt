package keyforge.counter.android

import keyforge.counter.android.core.di.coreModules
import keyforge.counter.android.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { LoginViewModel() }
}