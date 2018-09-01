package dev.com.sfilizzola.wunderchallenge.viewmodels

import dev.com.sfilizzola.wunderchallenge.repos.PlacemarksRepo
import javax.inject.Inject

class MapFragmentViewModel @Inject constructor(private var repository: PlacemarksRepo): BaseViewModel() {

}