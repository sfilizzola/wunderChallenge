package dev.com.sfilizzola.wunderchallenge.view.fragments

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
import com.google.android.gms.maps.model.MarkerOptions
import dev.com.sfilizzola.wunderchallenge.R
import dev.com.sfilizzola.wunderchallenge.databinding.FragmentMapBinding


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

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        currentMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        currentMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}