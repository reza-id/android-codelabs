package com.reza.codelabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_flow_step_one.*

class FlowStepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args
        val safeArgs: FlowStepFragmentArgs by navArgs()

        return when (safeArgs.flowStepNumber) {
            3 -> inflater.inflate(R.layout.fragment_flow_step_three, container, false)
            2 -> inflater.inflate(R.layout.fragment_flow_step_two, container, false)
            else -> inflater.inflate(R.layout.fragment_flow_step_one, container, false)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_next?.setOnClickListener {
            findNavController().navigate(R.id.action_step)
        }
    }

}