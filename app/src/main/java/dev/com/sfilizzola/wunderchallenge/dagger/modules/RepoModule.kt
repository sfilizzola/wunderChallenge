package dev.com.sfilizzola.wunderchallenge.dagger.modules

import dagger.Module
import dagger.Provides
import dev.com.sfilizzola.wunderchallenge.database.DatabaseClient
import dev.com.sfilizzola.wunderchallenge.database.daos.CarDao
import dev.com.sfilizzola.wunderchallenge.database.daos.PinDao
import dev.com.sfilizzola.wunderchallenge.network.NetworkClient
import dev.com.sfilizzola.wunderchallenge.repos.DataRepository
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideDataRepo(service: NetworkClient, databaseClient: DatabaseClient, carDao: CarDao, pinDao: PinDao):DataRepository{
        return DataRepository(service,databaseClient, carDao, pinDao)
    }
}