package dev.com.sfilizzola.wunderchallenge.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableInt
import android.view.View
import dev.com.sfilizzola.wunderchallenge.models.Car
import dev.com.sfilizzola.wunderchallenge.repos.PlacemarksRepo
import dev.com.sfilizzola.wunderchallenge.view.viewStatus.ListViewStatus
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ListFragmentViewModel @Inject constructor(private var repository: PlacemarksRepo) : BaseViewModel(){

    private var data = MutableLiveData<ListViewStatus>()

    var recyclerVisibility = ObservableInt(View.GONE)
    var progressVisibility = ObservableInt(View.VISIBLE)


    fun getCars(){
        showLoading(true);
        compositeDisposable.add(repository.getPlaceMarks().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    data.postValue(ListViewStatus.Success(it))
                    showLoading(false)
                }, {
                    data.postValue(ListViewStatus.Error(it.message))
                    showLoading(false)
                    Timber.e(it)
                }))
    }

    private fun showLoading(show: Boolean) {
        if (show){
            recyclerVisibility.set(View.GONE)
            progressVisibility.set(View.VISIBLE)
        } else {
            recyclerVisibility.set(View.VISIBLE)
            progressVisibility.set(View.GONE)
        }

    }

    fun getData(): LiveData<ListViewStatus> = data




}