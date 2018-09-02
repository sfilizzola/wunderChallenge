package dev.com.sfilizzola.wunderchallenge.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import dev.com.sfilizzola.wunderchallenge.models.Car
import io.reactivex.Single
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert


@Dao
interface CarDao{

    @Query("SELECT * FROM cars")
    fun getAllCars():Single<List<Car>>

    @Insert
    fun insertAll(cars:List<Car>)

    @Delete
    fun delete(car: Car)

}