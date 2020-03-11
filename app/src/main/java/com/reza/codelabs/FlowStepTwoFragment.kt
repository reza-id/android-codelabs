package com.reza.codelabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_flow_step_two.*

class FlowStepTwoFragment : Fragment(R.layout.fragment_flow_step_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val action = FlowStepTwoFragmentDirections.actionStep(98)
        bt_next.setOnClickListener { findNavController().navigate(action) }
    }
}