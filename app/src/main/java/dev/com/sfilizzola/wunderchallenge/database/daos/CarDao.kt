package dev.com.sfilizzola.wunderchallenge.database.daos

import android.arch.persistence.room.*
import dev.com.sfilizzola.wunderchallenge.models.Car
import io.reactivex.Single


@Dao
interface CarDao{

    @Query("SELECT * FROM cars")
    fun getAllCars():Single<List<Car>>

    @Transaction
    @Insert
    fun insertAll(cars:List<Car>)

    @Delete
    fun delete(car: Car)

}