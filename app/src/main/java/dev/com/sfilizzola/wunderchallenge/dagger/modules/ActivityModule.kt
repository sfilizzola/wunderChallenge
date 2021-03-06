package dev.com.sfilizzola.wunderchallenge.dagger.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.com.sfilizzola.wunderchallenge.view.activities.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}