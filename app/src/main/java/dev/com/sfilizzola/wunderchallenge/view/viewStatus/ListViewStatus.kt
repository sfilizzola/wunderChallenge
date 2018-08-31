package dev.com.sfilizzola.wunderchallenge.view.viewStatus

import dev.com.sfilizzola.wunderchallenge.models.Car

sealed class ListViewStatus {
    data class Success(val list:List<Car>):ListViewStatus()
    data class Error(val error:String?):ListViewStatus()

    fun list():List<Car>{
        return when(this){
            is Success -> this.list
            else -> ArrayList<Car>()
        }
    }

    fun error():String?{
        return when(this){
            is Error -> this.error
            else -> null
        }
    }
}