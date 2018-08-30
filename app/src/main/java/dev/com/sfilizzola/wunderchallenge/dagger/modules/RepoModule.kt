package dev.com.sfilizzola.adventurecompanion.dagger.modules

import dagger.Module
import dagger.Provides
import dev.com.sfilizzola.wunderchallenge.network.NetworkClient
import dev.com.sfilizzola.wunderchallenge.repos.PlacemarksRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun providePlacemarksRepo(service: NetworkClient):PlacemarksRepo{
        return PlacemarksRepo(service)
    }
}