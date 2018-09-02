package dev.com.sfilizzola.wunderchallenge.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(
        @PrimaryKey(autoGenerate = true)
        var carId: Int?,
        var address: String,
        var coordinates: ArrayList<Double>,
        var engineType: String,
        var exterior: String,
        var fuel: Int,
        var interior: String,
        var name: String,
        var vin: String)