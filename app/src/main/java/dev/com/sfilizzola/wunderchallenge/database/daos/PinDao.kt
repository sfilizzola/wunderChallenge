package dev.com.sfilizzola.wunderchallenge.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import dev.com.sfilizzola.wunderchallenge.models.Pin
import io.reactivex.Single

@Dao
interface PinDao {

    @Query("SELECT * FROM pins")
    fun getAllPins(): Single<List<Pin>>

    @Insert
    fun insertAll(pins:List<Pin>)

    @Delete
    fun delete(pins: Pin)
}