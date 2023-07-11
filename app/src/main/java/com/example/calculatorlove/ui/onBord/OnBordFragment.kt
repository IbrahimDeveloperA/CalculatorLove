package com.example.calculatorlove.ui.onBord

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculatorlove.R
import com.example.calculatorlove.databinding.FragmentOnBordBinding
import com.example.calculatorlove.ui.onBord.adapter.AdapterOnBord
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBordFragment  : Fragment(R.layout.fragment_on_bord) {

    private val binding: FragmentOnBordBinding by viewBinding(FragmentOnBordBinding::bind)
    private lateinit var adapterOnBord: AdapterOnBord
    private val viewModel:OnBordViewModel by viewModels ()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterOnBord = AdapterOnBord(this::onClick)
        binding.viewPager.adapter = adapterOnBord
        if (viewModel.isUserSeen()) {
            findNavController().navigate(R.id.calculatorFragment)
        }
        binding.indicator.setViewPager(binding.viewPager)
    }

    private fun onClick() {
        viewModel.saveUserSeen()
        findNavController().navigate(R.id.calculatorFragment)
    }
}