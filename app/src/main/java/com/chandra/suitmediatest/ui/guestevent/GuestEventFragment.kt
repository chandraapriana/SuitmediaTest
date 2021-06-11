package com.chandra.suitmediatest.ui.guestevent

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.FragmentGuestEventBinding
import com.chandra.suitmediatest.ui.guestevent.event.EventFragment
import com.chandra.suitmediatest.ui.guestevent.guest.GuestFragment
import com.chandra.suitmediatest.utils.SHARED_PREFERENCE_KEY
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.lang.StringBuilder

class GuestEventFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentGuestEventBinding
    private val viewModel: GuestEventViewModel by sharedViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestEventBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.name.observe(viewLifecycleOwner, {
            binding.tvName.text = StringBuilder("Nama : $it")
        })

        viewModel.nameGuest.observe(viewLifecycleOwner, {
            if (it != null) {
                binding.btnGuest.text = it
            }
        })

        binding.btnEvent.setOnClickListener(this)
        binding.btnGuest.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_event -> moveFragment(EventFragment())
            R.id.btn_guest -> moveFragment(GuestFragment())
        }
    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container_main, fragment).addToBackStack(null)
            .commit()
    }

}