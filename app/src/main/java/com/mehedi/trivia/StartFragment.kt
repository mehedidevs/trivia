package com.mehedi.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mehedi.trivia.databinding.FragmentStartBinding
import timber.log.Timber

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

        setListener()

        return binding.root
    }

    private fun setListener() {

        binding.playButton.setOnClickListener {

            Timber.i("Clicked ")

            // findNavController().navigate(StartFragmentDirections.actionStartFragmentToGameFragment())
        }


    }


}