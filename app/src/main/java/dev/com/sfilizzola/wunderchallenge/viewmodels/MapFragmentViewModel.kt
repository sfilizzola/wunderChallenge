package dev.com.sfilizzola.wunderchallenge.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableInt
import android.view.View
import dev.com.sfilizzola.wunderchallenge.repos.DataRepository
import dev.com.sfilizzola.wunderchallenge.view.viewStatus.MapViewStatus
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MapFragmentViewModel @Inject constructor(private var repository: DataRepository) : BaseViewModel() {

    private var data = MutableLiveData<MapViewStatus>()

    var progressVisibility = ObservableInt(View.VISIBLE)

    fun getMarkers(){
        showLoading(true);
        compositeDisposable.add(repository.getMarkers().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    data.postValue(MapViewStatus.Success(it))
                    showLoading(false)
                }, {
                    data.postValue(MapViewStatus.Error(it.message))
                    showLoading(false)
                    Timber.e(it)
                }))
    }



    private fun showLoading(show: Boolean) {
        if (show)
            progressVisibility.set(View.VISIBLE)
        else
            progressVisibility.set(View.GONE)
    }

    fun getData(): LiveData<MapViewStatus> = data


}