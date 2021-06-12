package com.chandra.suitmediatest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.FragmentHomeBinding
import com.chandra.suitmediatest.ui.guestevent.GuestEventFragment
import com.chandra.suitmediatest.ui.guestevent.GuestEventViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    private val viewModel : GuestEventViewModel by sharedViewModel()

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
                if (edtName.text.isNullOrEmpty()){
                    edtName.error = "Required"
                }else{
                    viewModel.setName(edtName.text.toString())
                    val guestEventFragment = GuestEventFragment()
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_main, guestEventFragment)
                        .addToBackStack(null)
                        .commit()
                }

            }
        }

    }


}