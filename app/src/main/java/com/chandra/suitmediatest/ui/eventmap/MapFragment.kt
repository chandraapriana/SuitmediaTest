package com.chandra.suitmediatest.ui.eventmap

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.FragmentMapBinding
import com.chandra.suitmediatest.utils.DataDummy
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
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
                    val customMarker: View =
                        (requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                            R.layout.custom_marker,
                            null
                        )
                    val tvMarkerText =
                        customMarker.findViewById<View>(R.id.marker_event_name) as TextView
                    tvMarkerText.text = listEvent[i].name
                    val iconMarker = customMarker.findViewById<View>(R.id.marker_img) as ImageView


                    val latitude: Float = listEvent[i].latitude.toFloat()
                    val longitude: Float = listEvent[i].longitude.toFloat()
                    val addressEvent = LatLng(
                        latitude.toDouble(), longitude.toDouble()
                    )

                    markerOptions.position(addressEvent)

                    if (it == i) {
                        iconMarker.backgroundTintList =
                            ColorStateList.valueOf(resources.getColor(R.color.green))
                        val icon = BitmapDescriptorFactory.fromBitmap(
                            createDrawableFromView(
                                requireContext(),
                                customMarker
                            )
                        )
                        googleMap.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                addressEvent,
                                17f
                            )
                        )
                        googleMap.addMarker(markerOptions.icon(icon))
                    } else {

                        iconMarker.backgroundTintList =
                            ColorStateList.valueOf(resources.getColor(R.color.yellow))
                        val icon = BitmapDescriptorFactory.fromBitmap(
                            createDrawableFromView(
                                requireContext(),
                                customMarker
                            )
                        )
                        googleMap.addMarker(markerOptions.icon(icon))
                    }

                }

            })


        }
    }

    private fun createDrawableFromView(context: Context, view: View): Bitmap? {
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        view.layoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
        view.buildDrawingCache()
        val bitmap =
            Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }

}

//
//for (i in listEvent.indices) {
//    val latitude: Float = listEvent[i].latitude.toFloat()
//    val longitude: Float = listEvent[i].longitude.toFloat()
//    val addressEvent = LatLng(
//        latitude.toDouble(), longitude.toDouble()
//    )
//    markerOptions.position(addressEvent)
//    markerOptions.title(listEvent[i].name)
//    if (it == i) {
//        googleMap.moveCamera(
//            CameraUpdateFactory.newLatLngZoom(
//                addressEvent,
//                15f
//            )
//        )
//
//        googleMap.addMarker(markerOptions).showInfoWindow()
//    } else {
//        googleMap.addMarker(markerOptions)
//    }
//
//}