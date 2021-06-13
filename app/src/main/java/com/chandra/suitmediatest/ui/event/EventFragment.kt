package com.chandra.suitmediatest.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.data.model.Event
import com.chandra.suitmediatest.databinding.FragmentEventBinding
import com.chandra.suitmediatest.ui.eventmap.EventMapFragment
import com.chandra.suitmediatest.ui.guestevent.GuestEventFragment
import com.chandra.suitmediatest.ui.guestevent.GuestEventViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class EventFragment : Fragment() {
    private val viewModel: EventViewModel by viewModel()
    private val guestEventViewModel: GuestEventViewModel by sharedViewModel()

    private lateinit var binding: FragmentEventBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarEvent.btnMaps.setOnClickListener {
            moveFragment(EventMapFragment())
        }

        val listEvent = viewModel.getDummyEvent()
        val eventAdapter = EventAdapter()
        eventAdapter.setEvent(listEvent)

        with(binding.rvEvent) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = eventAdapter
        }

        eventAdapter.setOnItemClickCallback(object : EventAdapter.OnItemClickCallback {
            override fun onItemClicked(event: Event) {
                guestEventViewModel.setNameEvent(event.name)
                moveFragment(GuestEventFragment())

            }
        })
    }

    fun moveFragment(fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container_main, fragment)
            .addToBackStack(null)
            .commit()
    }

}