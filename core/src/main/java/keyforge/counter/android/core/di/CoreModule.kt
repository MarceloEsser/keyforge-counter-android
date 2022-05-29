package keyforge.counter.android.core.di

import androidx.work.WorkManager
import keyforge.counter.android.core.NetworkHandler
import keyforge.counter.android.core.helper.WorkScheduler
import keyforge.counter.android.core.service.history.HistoryServiceImpl
import keyforge.counter.android.core.service.history.IHistoryApi
import keyforge.counter.android.core.service.history.IHistoryService
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * @author Marcelo Esser
 * @author marcelo.v.esser@gmail.com
 *
 * @location Rio Grande do Sul, Brazil
 * @since 06/05/22
 */
private val workModule = module {
    single { WorkManager.getInstance(get()) }
    single { WorkScheduler(get()) }
}

private val historyModule = module {
    single { NetworkHandler.getRetrofit() }

    single { get<Retrofit>().create(IHistoryApi::class.java) }
    single<IHistoryService> { HistoryServiceImpl(get(), get()) }
}

val coreModules = listOf(historyModule, workModule)