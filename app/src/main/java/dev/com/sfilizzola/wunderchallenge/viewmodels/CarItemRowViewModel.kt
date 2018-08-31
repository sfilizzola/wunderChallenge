package dev.com.sfilizzola.wunderchallenge.viewmodels

import android.databinding.Bindable
import dev.com.sfilizzola.wunderchallenge.models.Car

class CarItemRowViewModel constructor(private val item:Car): BaseViewModel() {

    @Bindable
    fun getName():String = item.name

    @Bindable
    fun getAddress():String = item.address

    @Bindable
    fun getEngineType():String = item.engineType

    @Bindable
    fun getExterior():String = item.exterior

    @Bindable
    fun getInterior():String = item.interior

    @Bindable
    fun getVin():String = item.vin

    @Bindable
    fun getFuel():Int = item.fuel

    fun onRowClick(){

    }
}