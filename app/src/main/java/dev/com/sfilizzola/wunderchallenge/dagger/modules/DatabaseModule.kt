package dev.com.sfilizzola.wunderchallenge.dagger.modules

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import dev.com.sfilizzola.wunderchallenge.BaseApp
import dev.com.sfilizzola.wunderchallenge.database.DatabaseClient
import dev.com.sfilizzola.wunderchallenge.database.daos.CarDao
import dev.com.sfilizzola.wunderchallenge.database.daos.PinDao

import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: BaseApp): DatabaseClient {
        return Room.databaseBuilder(application, DatabaseClient::class.java, "wunderChallenge-db")
                .build()
    }

    @Provides @Singleton
    fun provideCarDao(databaseClient: DatabaseClient): CarDao {
        return databaseClient.carDao()
    }

    @Provides @Singleton
    fun providePinDao(databaseClient: DatabaseClient): PinDao {
        return databaseClient.pinDao()
    }
}