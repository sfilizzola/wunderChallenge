package dev.com.sfilizzola.adventurecompanion.dagger.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.com.sfilizzola.adventurecompanion.view.MainActivity
import dev.com.sfilizzola.adventurecompanion.view.activities.CharacterChooserActivity
import dev.com.sfilizzola.adventurecompanion.view.activities.NewCharacterBasicActivity
import dev.com.sfilizzola.adventurecompanion.view.activities.TestActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindTestActivity(): TestActivity

    @ContributesAndroidInjector
    abstract fun bindCharChooserActivity(): CharacterChooserActivity

    @ContributesAndroidInjector
    abstract fun bindNewCharBasicActivity(): NewCharacterBasicActivity

}