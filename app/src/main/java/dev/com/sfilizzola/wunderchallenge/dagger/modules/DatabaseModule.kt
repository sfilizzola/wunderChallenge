package dev.com.sfilizzola.adventurecompanion.dagger.modules

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import dev.com.sfilizzola.adventurecompanion.BaseApp
import dev.com.sfilizzola.adventurecompanion.database.DatabaseClient
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: BaseApp): DatabaseClient {
        return Room.databaseBuilder(application, DatabaseClient::class.java, "advComp-db")
                .build()
    }
}