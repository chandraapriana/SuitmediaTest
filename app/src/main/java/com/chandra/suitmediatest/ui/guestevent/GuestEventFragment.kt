package com.chandra.suitmediatest.ui.guestevent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.FragmentGuestEventBinding
import com.chandra.suitmediatest.ui.guestevent.event.EventFragment
import com.chandra.suitmediatest.ui.guestevent.guest.GuestFragment
import com.chandra.suitmediatest.utils.DateConverter
import com.chandra.suitmediatest.utils.PhoneType
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

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

        viewModel.nameEvent.observe(viewLifecycleOwner, {
            if (it != null) {
                binding.btnEvent.text = it
            }
        })

        viewModel.date?.observe(viewLifecycleOwner, {
            if (it != null) {

                val date = DateConverter.getDate(it)
                val phoneType = PhoneType.getPhoneType(date)
                Toast.makeText(context, phoneType, Toast.LENGTH_SHORT).show()
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

    override fun onDestroy() {
        super.onDestroy()
        viewModel.setDate(null)
    }

    override fun onPause() {
        super.onPause()
        viewModel.setDate(null)
    }


}