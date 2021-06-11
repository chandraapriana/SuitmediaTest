package com.chandra.suitmediatest.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.FragmentHomeBinding
import com.chandra.suitmediatest.ui.guestevent.GuestEventFragment

class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding.apply {
            btnNext.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(GuestEventFragment.NAME,edtName.text.toString())
                val guestEventFragment = GuestEventFragment()
                guestEventFragment.arguments = bundle
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_main, guestEventFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


}