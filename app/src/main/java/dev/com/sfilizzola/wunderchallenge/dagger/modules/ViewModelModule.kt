package dev.com.sfilizzola.wunderchallenge.dagger.modules

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dev.com.sfilizzola.wunderchallenge.dagger.AppViewModelFactory

@Module
abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(MainActivityViewModel::class)
//    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel):ViewModel

    @Binds
    internal abstract fun bindAppViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}