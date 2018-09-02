package dev.com.sfilizzola.wunderchallenge.view.fragments

import android.Manifest
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.location.LocationManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import dev.com.sfilizzola.wunderchallenge.R
import dev.com.sfilizzola.wunderchallenge.databinding.FragmentMapBinding
import dev.com.sfilizzola.wunderchallenge.models.Pin
import dev.com.sfilizzola.wunderchallenge.view.viewStatus.MapViewStatus


import dev.com.sfilizzola.wunderchallenge.viewmodels.MapFragmentViewModel
import javax.inject.Inject

class MapFragment : BaseFragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowCloseListener {


    private lateinit var currentMap: GoogleMap
    private lateinit var allPins: List<Pin>
    private val markerList = ArrayList<Marker>()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MapFragmentViewModel::class.java) }

    private lateinit var binding: FragmentMapBinding

    private var showingAllPins = true

    private val boundBuilder = LatLngBounds.builder()

    private lateinit var locationManager:LocationManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)
        binding.viewModel = viewModel

        //binding seems to not work with fragment inside fragments :o
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        //start location manager
        locationManager =  context!!.getSystemService(LOCATION_SERVICE) as LocationManager

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {

        currentMap = googleMap

        if (ContextCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            currentMap.isMyLocationEnabled = true
            currentMap.uiSettings.isMyLocationButtonEnabled =true
        }

        currentMap.setOnMarkerClickListener(this)
        currentMap.setOnInfoWindowCloseListener(this)

        viewModel.getMarkers()

        viewModel.getData().observe(this, Observer{
            it?.let { result ->
                when(result) {
                    is MapViewStatus.Success -> {
                        allPins = it.list()
                        setUpMarkers(it.list())
                    }
                    is MapViewStatus.Error ->  displaySnackBarError()
                }
            }
        })


    }

    private fun setUpMarkers(list: List<Pin>) {

        for(item in list){
            val latLng = LatLng(item.Lat, item.Lng)
            markerList.add(currentMap.addMarker(MarkerOptions().position(latLng).title(item.title)))
            boundBuilder.include(latLng)
        }
        zoomToBounds(boundBuilder.build())
    }

    override fun onMarkerClick(marker: Marker): Boolean {

        if (showingAllPins) {
            showingAllPins = false
            currentMap.clear()

            val currentPin = currentMap.addMarker(MarkerOptions().position(marker.position).title(marker.title))
            currentPin.showInfoWindow()

            zoomToPosition(marker.position)
        }

        return true
    }

    override fun onInfoWindowClose(marker: Marker) {
        for (item in markerList){
            if (marker.position != item.position)
                currentMap.addMarker(MarkerOptions().position(item.position).title(item.title))
        }
        showingAllPins = true
        zoomToBounds(boundBuilder.build())
    }

    private fun zoomToPosition(position:LatLng){
        val camera = CameraUpdateFactory.newLatLngZoom(position, 18.0f)
        currentMap.animateCamera(camera)
    }

    private fun zoomToBounds(bounds:LatLngBounds){
        val camera = CameraUpdateFactory.newLatLngBounds(bounds, 50)
        currentMap.animateCamera(camera)
    }

    private fun displaySnackBarError() {
        Snackbar.make(binding.root, R.string.retry_connection, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.retry_text) {
                    viewModel.getMarkers()
                }.show()
    }



}