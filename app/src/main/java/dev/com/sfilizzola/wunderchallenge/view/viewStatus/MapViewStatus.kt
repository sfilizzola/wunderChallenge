package dev.com.sfilizzola.wunderchallenge.view.viewStatus

import dev.com.sfilizzola.wunderchallenge.models.Marker

sealed class MapViewStatus {
    data class Success(val list:List<Marker>):MapViewStatus()
    data class Error(val error:String?):MapViewStatus()

    fun list():List<Marker>{
        return when(this){
            is Success -> this.list
            else -> ArrayList<Marker>()
        }
    }

    fun error():String?{
        return when(this){
            is Error -> this.error
            else -> null
        }
    }
}