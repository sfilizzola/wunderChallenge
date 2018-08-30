package dev.com.sfilizzola.wunderchallenge.viewmodels

import dev.com.sfilizzola.wunderchallenge.repos.PlacemarksRepo
import javax.inject.Inject

class ListFragmentViewModel @Inject constructor(repo: PlacemarksRepo) : BaseViewModel()