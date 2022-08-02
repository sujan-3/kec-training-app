package com.kec.trainingapp.login.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.kec.trainingapp.MainViewModel
import com.kec.trainingapp.databinding.FragmentAddBinding
import com.kec.trainingapp.databinding.FragmentListBinding

class ListFragment: Fragment() {

    lateinit var binding: FragmentListBinding
    private val viewModel: MainViewModel by activityViewModels()

    private val TAG = "ListFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "MSG onViewCreated")

        viewModel.getM().observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "MSG called in list " + it)
        })
    }

}