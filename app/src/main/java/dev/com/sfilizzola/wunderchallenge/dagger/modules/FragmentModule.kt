package dev.com.sfilizzola.adventurecompanion.dagger.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.com.sfilizzola.adventurecompanion.view.fragments.RaceCardFragment

@Module
abstract class FragmentModule{

    @ContributesAndroidInjector
    abstract fun bindRaceCardFragment(): RaceCardFragment

}