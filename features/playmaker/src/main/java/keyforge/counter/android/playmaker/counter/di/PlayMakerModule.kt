package keyforge.counter.android.playmaker.counter.di

import keyforge.counter.android.playmaker.counter.CounterViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val viewModel = module {
    viewModel { CounterViewModel(get(), get(), Dispatchers.IO) }
}

val playMakerModules = listOf(viewModel)