package dev.com.sfilizzola.wunderchallenge.repos

import dev.com.sfilizzola.wunderchallenge.models.Car
import dev.com.sfilizzola.wunderchallenge.network.NetworkClient
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class PlacemarksRepo @Inject constructor(private var service:NetworkClient){

    fun getPlaceMarks():Single<List<Car>>{
        return service.getLocationResponse().flatMapPublisher {
            Flowable.fromIterable(it.placemarks)
        }.map {
            Car(it.address, it.coordinates, it.engineType, it.exterior, it.fuel, it.interior, it.name, it.vin)
        }.toList()
    }
}