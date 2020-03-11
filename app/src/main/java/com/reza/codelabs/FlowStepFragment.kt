package com.reza.codelabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FlowStepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return when (arguments?.getInt("flowStepNumber")) {
            3 -> inflater.inflate(R.layout.fragment_flow_step_three, container, false)
            2 -> inflater.inflate(R.layout.fragment_flow_step_two, container, false)
            else -> inflater.inflate(R.layout.fragment_flow_step_one, container, false)
        }
    }


}