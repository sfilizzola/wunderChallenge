package dev.com.sfilizzola.wunderchallenge.view.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import dev.com.sfilizzola.wunderchallenge.R
import dev.com.sfilizzola.wunderchallenge.databinding.FragmentMapBinding
import dev.com.sfilizzola.wunderchallenge.models.Marker
import dev.com.sfilizzola.wunderchallenge.view.viewStatus.MapViewStatus


import dev.com.sfilizzola.wunderchallenge.viewmodels.MapFragmentViewModel
import javax.inject.Inject

class MapFragment : BaseFragment(), OnMapReadyCallback {

    private lateinit var currentMap: GoogleMap

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MapFragmentViewModel::class.java) }

    private lateinit var binding: FragmentMapBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)
        binding.viewModel = viewModel

        //binding seems to not work with fragment inside fragments :o
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        currentMap = googleMap

        viewModel.getMarkers()

        viewModel.getData().observe(this, Observer{
            it?.let { result ->
                when(result) {
                    is MapViewStatus.Success -> setUpMarkers(it.list())
                    is MapViewStatus.Error ->  displaySnackBarError()
                }
            }
        })


    }

    private fun setUpMarkers(list: List<Marker>) {

        val boundBuilder = LatLngBounds.builder()

        for(item in list){
            val latLng = LatLng(item.Lat, item.Lng)
            currentMap.addMarker(MarkerOptions().position(latLng).title(item.title))
            boundBuilder.include(latLng)
        }

        val camera = CameraUpdateFactory.newLatLngBounds(boundBuilder.build(), 50)
        currentMap.moveCamera(camera)
    }



    private fun displaySnackBarError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}