package com.reza.codelabs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.reza.codelabs.MyApp
import com.reza.codelabs.R
import com.reza.codelabs.databinding.FragmentEggTimerBinding

class EggTimerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentEggTimerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_egg_timer, container, false
        )

        val viewModel = ViewModelProvider(this, EggTimerViewModelFactory(context?.applicationContext as MyApp))[EggTimerViewModel::class.java]
        binding.eggTimerViewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    companion object {
        fun newInstance() = EggTimerFragment()
    }
}
