package com.reza.codelabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_flow_step_three.*

class FlowStepThreeFragment : Fragment(R.layout.fragment_flow_step_three) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_finish.setOnClickListener { findNavController().navigate(R.id.action_finish) }
    }
}