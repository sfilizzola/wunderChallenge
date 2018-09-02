package dev.com.sfilizzola.wunderchallenge.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "pins")
data class Pin(
        @PrimaryKey(autoGenerate = true)
        var pinId: Int?,
        var title: String,
        var Lat: Double,
        var Lng: Double)