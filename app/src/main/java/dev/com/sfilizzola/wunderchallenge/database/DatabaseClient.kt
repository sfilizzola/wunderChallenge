package dev.com.sfilizzola.wunderchallenge.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import dev.com.sfilizzola.wunderchallenge.database.daos.CarDao
import dev.com.sfilizzola.wunderchallenge.database.daos.PinDao
import dev.com.sfilizzola.wunderchallenge.models.Car
import dev.com.sfilizzola.wunderchallenge.models.Pin

@Database(entities = arrayOf(Car::class, Pin::class), version = 1)
@TypeConverters(Converter::class)
abstract class DatabaseClient : RoomDatabase() {
    abstract fun carDao(): CarDao
    abstract fun pinDao(): PinDao
}