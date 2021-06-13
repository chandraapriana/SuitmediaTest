package com.chandra.suitmediatest.ui.eventmap

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.data.model.Event
import com.chandra.suitmediatest.databinding.FragmentEventMapBinding
import com.chandra.suitmediatest.utils.DataDummy
import org.koin.androidx.viewmodel.ext.android.sharedStateViewModel
import java.lang.Math.abs


class EventMapFragment : Fragment() {

    private lateinit var binding: FragmentEventMapBinding
    private val eventMapViewModel: EventMapViewModel by sharedStateViewModel()
    private lateinit var viewPager2: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventMapBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.beginTransaction().replace(R.id.layout_gmaps, MapFragment()).commit()
        binding.toolbarEventMap.apply {
            btnBack.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.yellow))
            btnSearch.backgroundTintList =
                ColorStateList.valueOf(resources.getColor(R.color.yellow))
            btnMaps.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.yellow))
            tvToolbarMessage.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.yellow)))
        }

        viewPager2 = binding.viewpagerMap
        val listEvent: MutableList<Event> = ArrayList()
        listEvent.addAll(DataDummy.generateDummyEvent())

        viewPager2.adapter = SliderAdapter(listEvent, viewPager2)
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.25f

        }

        viewPager2.setPageTransformer(compositePageTransformer)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                eventMapViewModel.setPosition(position)
            }
        })


    }


}