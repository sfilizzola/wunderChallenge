package dev.com.sfilizzola.adventurecompanion.dagger.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.com.sfilizzola.wunderchallenge.dagger.AppViewModelFactory
import dev.com.sfilizzola.wunderchallenge.dagger.ViewModelKey
import dev.com.sfilizzola.wunderchallenge.viewmodels.MainActivityViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel):ViewModel

    @Binds
    internal abstract fun bindAppViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}