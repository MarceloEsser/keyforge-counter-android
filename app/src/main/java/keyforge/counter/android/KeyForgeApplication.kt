package keyforge.counter.android

import android.app.Application
import keyforge.counter.android.core.di.coreModules
import keyforge.counter.android.playmaker.counter.di.playMakerModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class KeyForgeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = mutableListOf<Module>()

        modules.addAll(coreModules)
        modules.add(viewModel)
        modules.addAll(playMakerModules)

        startKoin {
            androidContext(this@KeyForgeApplication)
            modules(modules)
        }
    }
}