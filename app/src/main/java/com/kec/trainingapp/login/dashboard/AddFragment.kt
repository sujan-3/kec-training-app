package com.kec.trainingapp.login.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.kec.trainingapp.MainViewModel
import com.kec.trainingapp.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    lateinit var binding: com.kec.trainingapp.databinding.FragmentAddBinding
    private val viewModel: MainViewModel by activityViewModels()
    private val TAG = "AddFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "MSG onViewCreated")

        binding.btn.setOnClickListener {
            viewModel.sendMessage("Clciked from add fragment")
        }
    }
}