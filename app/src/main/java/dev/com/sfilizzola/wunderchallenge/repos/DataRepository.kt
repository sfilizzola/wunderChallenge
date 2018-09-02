package dev.com.sfilizzola.wunderchallenge.repos

import dev.com.sfilizzola.wunderchallenge.database.DatabaseClient
import dev.com.sfilizzola.wunderchallenge.database.daos.CarDao
import dev.com.sfilizzola.wunderchallenge.database.daos.PinDao
import dev.com.sfilizzola.wunderchallenge.models.Car
import dev.com.sfilizzola.wunderchallenge.models.Pin
import dev.com.sfilizzola.wunderchallenge.network.NetworkClient
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class DataRepository @Inject constructor(private var service: NetworkClient,
                                         private var database:DatabaseClient,
                                         private var carDao: CarDao,
                                         private var pinDao: PinDao) {

    fun getPlaceMarks(): Single<List<Car>> {
        return getCarsFromAPI()
    }


    fun getMarkers(): Single<List<Pin>> {
       return getPinsFromAPI()
    }

    private fun getCarsFromAPI(): Single<List<Car>> {
        return service.getLocationResponse().flatMapPublisher {
            Flowable.fromIterable(it.placemarks)
        }.map {
            Car(null, it.address, it.coordinates, it.engineType, it.exterior, it.fuel, it.interior, it.name, it.vin)
        }.toList()
    }

    private fun getCarsFromDatabase(): Single<List<Car>> {
        return carDao.getAllCars()
    }

    private fun getPinsFromAPI(): Single<List<Pin>> {
        return service.getLocationResponse().flatMapPublisher {
            Flowable.fromIterable(it.placemarks)
        }.map {
            Pin(null, it.name, it.coordinates[1], it.coordinates[0])
        }.toList()
    }

    private fun getPinsFromDatabase(): Single<List<Pin>> {
        return pinDao.getAllPins()
    }
}