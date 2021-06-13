package com.chandra.suitmediatest.ui.eventmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.FragmentMapBinding
import com.chandra.suitmediatest.utils.DataDummy
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MapFragment : Fragment() {
    private lateinit var binding: FragmentMapBinding
    private val eventMapViewModel: EventMapViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listEvent = DataDummy.generateDummyEvent()
        val supportMapFragment: SupportMapFragment =
            childFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment
        supportMapFragment.getMapAsync { googleMap ->

            eventMapViewModel.position.observe(viewLifecycleOwner, {
                googleMap.clear()
                val markerOptions = MarkerOptions()

                for (i in listEvent.indices) {
                    val latitude: Float = listEvent[i].latitude.toFloat()
                    val longitude: Float = listEvent[i].longitude.toFloat()
                    val addressEvent = LatLng(
                        latitude.toDouble(), longitude.toDouble()
                    )
                    markerOptions.position(addressEvent)
                    markerOptions.title(listEvent[i].name)
                    if (it == i) {
                        googleMap.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                addressEvent,
                                15f
                            )
                        )

                        googleMap.addMarker(markerOptions).showInfoWindow()
                    } else {
                        googleMap.addMarker(markerOptions)
                    }

                }

            })


        }
    }

}