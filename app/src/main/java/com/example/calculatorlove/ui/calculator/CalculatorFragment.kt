package com.example.calculatorlove.ui.calculator

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculatorlove.R
import com.example.calculatorlove.databinding.FragmentCalculatorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorFragment : Fragment(R.layout.fragment_calculator) {

    private lateinit var viewModel: LoveViewModel
    private val binding: FragmentCalculatorBinding by viewBinding(FragmentCalculatorBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[LoveViewModel::class.java]
        binding.btnGet.setOnClickListener {
            viewModel.getLoveData(
                binding.etFirs.text.toString(),
                binding.etSecond.text.toString()
            ).observe(
                viewLifecycleOwner, Observer {
                    findNavController().navigate(R.id.resultFragment, bundleOf(KEY_FOR_DATA to it))
                    binding.etFirs.text.clear()
                    binding.etSecond.text.clear()
                })
        }
    }


    companion object {
        const val KEY_FOR_DATA = "ololo"
    }
}