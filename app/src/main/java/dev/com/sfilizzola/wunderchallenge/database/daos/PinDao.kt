package dev.com.sfilizzola.wunderchallenge.database.daos

import android.arch.persistence.room.*
import dev.com.sfilizzola.wunderchallenge.models.Pin
import io.reactivex.Single

@Dao
interface PinDao {

    @Query("SELECT * FROM pins")
    fun getAllPins(): Single<List<Pin>>

    @Transaction
    @Insert
    fun insertAll(pins:List<Pin>)

    @Delete
    fun delete(pins: Pin)
}