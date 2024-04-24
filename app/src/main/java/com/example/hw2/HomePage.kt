package com.example.hw2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.hw2.databinding.FragmentHomePageBinding
import com.google.android.material.snackbar.Snackbar


class HomePage : Fragment() {

private lateinit var binding: FragmentHomePageBinding

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_homePage_to_firstPage)
        }

        return binding.root
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_home_page, container, false)
    }


}

/*
* package com.example.hw2



class HomePage : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using data binding
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        binding.button.visibility = View.GONE

        // Butona tıklandığında Snackbar göster
        binding.button.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.layout.activity_main)
        }

        return binding.root
    }
}

* */