package dev.com.sfilizzola.wunderchallenge.database

import android.arch.persistence.room.RoomDatabase

//@Database(entities = arrayOf(Drink::class), version = 1)
abstract class DatabaseClient : RoomDatabase() {
    //abstract fun drinkDAO(): DrinkDao
}