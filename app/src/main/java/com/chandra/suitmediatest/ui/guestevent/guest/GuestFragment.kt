package com.chandra.suitmediatest.ui.guestevent.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.data.model.Guest
import com.chandra.suitmediatest.databinding.FragmentGuestBinding
import com.chandra.suitmediatest.ui.guestevent.GuestEventFragment
import com.chandra.suitmediatest.ui.guestevent.GuestEventViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class GuestFragment : Fragment() {

    private lateinit var binding: FragmentGuestBinding
    private val viewModel: GuestViewModel by viewModel()
    private val guestEventViewModel : GuestEventViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val data = viewModel.getGuest()
            val guestAdapter = GuestAdapter()
            guestAdapter.setGuest(data)

            with(binding.rvGuest) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = guestAdapter

            }
            guestAdapter.setOnItemClickCallback(object : GuestAdapter.OnItemClickCallback {
                override fun onItemClicked(guest: Guest) {
                    guestEventViewModel.setNameGuest(guest.name)
                    guestEventViewModel.setDate(guest.birthdate)
                    val guestEventFragment = GuestEventFragment()
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_main, guestEventFragment)
                        .addToBackStack(null)
                        .commit()
                }
            })
        }


    }




}