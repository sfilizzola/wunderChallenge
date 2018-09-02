package dev.com.sfilizzola.wunderchallenge.view.viewStatus

import dev.com.sfilizzola.wunderchallenge.models.Pin

sealed class MapViewStatus {
    data class Success(val list:List<Pin>):MapViewStatus()
    data class Error(val error:String?):MapViewStatus()

    fun list():List<Pin>{
        return when(this){
            is Success -> this.list
            else -> ArrayList<Pin>()
        }
    }

    fun error():String?{
        return when(this){
            is Error -> this.error
            else -> null
        }
    }
}