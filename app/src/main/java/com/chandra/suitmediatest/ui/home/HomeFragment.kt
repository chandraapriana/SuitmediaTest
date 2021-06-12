package com.chandra.suitmediatest.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.databinding.FragmentHomeBinding
import com.chandra.suitmediatest.ui.guestevent.GuestEventFragment
import com.chandra.suitmediatest.ui.guestevent.GuestEventViewModel
import com.chandra.suitmediatest.utils.Palindrome
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    private val viewModel: GuestEventViewModel by sharedViewModel()

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
                if (edtName.text.isNullOrEmpty()) {
                    edtName.error = "Required"
                } else {
                    viewModel.setName(edtName.text.toString())
                    isPalindrome(edtName.text.toString())
                }
            }
            btnNext.backgroundTintList = null
        }
    }

    private fun isPalindrome(name:String){
        if (Palindrome.isPalindrome(name)){
            showDialog("is Palindrome")
        }else{
            showDialog("Not Palindrome")
        }
    }

    private fun showDialog(message:String){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("isPalindrome")
        builder.setMessage("Your name $message")
        builder.setPositiveButton("Continue") { dialogInterface: DialogInterface, i: Int ->
            moveFragment(GuestEventFragment())
        }
        builder.show()

    }

    private fun moveFragment(fragment:Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container_main, fragment)
            .addToBackStack(null)
            .commit()
    }

}