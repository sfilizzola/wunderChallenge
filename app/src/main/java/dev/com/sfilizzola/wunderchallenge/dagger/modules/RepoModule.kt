package dev.com.sfilizzola.adventurecompanion.dagger.modules

import dagger.Module
import dagger.Provides
import dev.com.sfilizzola.adventurecompanion.network.NetworkClient
import dev.com.sfilizzola.adventurecompanion.repos.CharListRepo
import dev.com.sfilizzola.adventurecompanion.repos.RaceListRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideRaceListModule(service:NetworkClient):RaceListRepo{
        return RaceListRepo(service)
    }

    @Provides
    @Singleton
    fun provideCharListModule():CharListRepo{
        return CharListRepo()
    }
}