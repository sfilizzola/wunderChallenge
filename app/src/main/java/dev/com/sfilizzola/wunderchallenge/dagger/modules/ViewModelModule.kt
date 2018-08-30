package dev.com.sfilizzola.adventurecompanion.dagger.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.com.sfilizzola.adventurecompanion.dagger.AppViewModelFactory
import dev.com.sfilizzola.adventurecompanion.dagger.ViewModelKey
import dev.com.sfilizzola.adventurecompanion.viewmodels.CharacterChooserViewModel
import dev.com.sfilizzola.adventurecompanion.viewmodels.NewCharBasicViewModel
import dev.com.sfilizzola.adventurecompanion.viewmodels.RaceFragmentViewModel
import dev.com.sfilizzola.adventurecompanion.viewmodels.TestViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    internal abstract fun bindTestViewModel(testViewModel: TestViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterChooserViewModel::class)
    internal abstract fun bindCharacterChooserViewModel(characterChooserViewModel: CharacterChooserViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewCharBasicViewModel::class)
    internal abstract fun bindNewCharBasicViewModel(newCharBasicViewModel: NewCharBasicViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RaceFragmentViewModel::class)
    internal abstract fun bindRaceFragmentViewModel(raceFragmentViewModel: RaceFragmentViewModel):ViewModel


    @Binds
    internal abstract fun bindAppViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}