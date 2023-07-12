package com.example.calculatorlove.ui.calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculatorlove.App
import com.example.calculatorlove.R
import com.example.calculatorlove.databinding.FragmentCalculatorBinding
import com.example.calculatorlove.ui.calculator.viewmodel.LoveViewModel
import com.example.calculatorlove.ui.history.HistoryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorFragment : Fragment(R.layout.fragment_calculator) {

    private val viewModel: LoveViewModel by viewModels()
    private val binding: FragmentCalculatorBinding by viewBinding(FragmentCalculatorBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
        binding.btnGet.setOnClickListener {
            viewModel.getLoveData(
                binding.etFirs.text.toString(),
                binding.etSecond.text.toString()
            ).observe(
                viewLifecycleOwner, Observer {
                    if (binding.etFirs.text.toString() == "" && binding.etSecond.text.toString() == "") {
                        Toast.makeText(
                            requireContext(),
                            "Поле не может быть пустым",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.insert(it)
                        findNavController().navigate(
                            R.id.resultFragment,
                            bundleOf(KEY_FOR_DATA to it)
                        )
                        binding.etFirs.text.clear()
                        binding.etSecond.text.clear()
                    }
                })
        }
    }

    companion object {
        const val KEY_FOR_DATA = "ololo"
    }
}