package com.chandra.suitmediatest.ui.guest

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.data.model.Guest
import com.chandra.suitmediatest.databinding.FragmentGuestBinding
import com.chandra.suitmediatest.ui.guestevent.GuestEventFragment
import com.chandra.suitmediatest.ui.guestevent.GuestEventViewModel
import com.chandra.suitmediatest.utils.DateConverter
import com.chandra.suitmediatest.utils.InternetConnection
import com.chandra.suitmediatest.utils.PrimeNumber
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class GuestFragment : Fragment() {

    private lateinit var binding: FragmentGuestBinding
    private val viewModel: GuestViewModel by viewModel()
    private val guestEventViewModel: GuestEventViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadGuest()
        refreshApp()


    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun refreshApp() {
        binding.swipeToRefresh.setOnRefreshListener {
            if (InternetConnection.isOnline(requireContext())) {
                loadGuest()
                Toast.makeText(context, "Refreshed", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "No Connection", Toast.LENGTH_SHORT).show()
            }
            binding.swipeToRefresh.isRefreshing = false
        }


    }

    private fun loadGuest() {
        lifecycleScope.launch {
            binding.progressbarGuest.visibility = View.VISIBLE
            var data : List<Guest> = viewModel.getGuest()
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
                    checkPrimeNumber(guest.birthdate)

                }
            })
            binding.progressbarGuest.visibility = View.GONE
        }
    }

    fun checkPrimeNumber(date: String) {
        val month = DateConverter(date).getMonth()
        val isPrime = PrimeNumber.checkPrimeNumber(month)
        if (isPrime) {
            showDialog(isPrime.toString())
        } else {
            showDialog(isPrime.toString())
        }
    }

    private fun showDialog(message: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Prime Month")
        builder.setMessage("is month as a prime number = $message")
        builder.setPositiveButton("Continue") { dialogInterface: DialogInterface, i: Int ->
            moveFragment(GuestEventFragment())
        }
        builder.show()

    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container_main, fragment)
            .addToBackStack(null)
            .commit()
    }


}