package dev.com.sfilizzola.wunderchallenge.dagger.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.com.sfilizzola.wunderchallenge.dagger.AppViewModelFactory
import dev.com.sfilizzola.wunderchallenge.dagger.ViewModelKey
import dev.com.sfilizzola.wunderchallenge.viewmodels.ListFragmentViewModel
import dev.com.sfilizzola.wunderchallenge.viewmodels.MapFragmentViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListFragmentViewModel::class)
    internal abstract fun bindListFragmentViewModel(listFragmentViewModel: ListFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MapFragmentViewModel::class)
    internal abstract fun bindMapFragmentViewModel(mapFragmentViewModel: MapFragmentViewModel): ViewModel

    @Binds
    internal abstract fun bindAppViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}