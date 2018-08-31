package dev.com.sfilizzola.wunderchallenge.dagger.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.com.sfilizzola.wunderchallenge.view.fragments.ListFragment

@Module
abstract class FragmentModule{

    @ContributesAndroidInjector
    abstract fun bindListFragment(): ListFragment

}