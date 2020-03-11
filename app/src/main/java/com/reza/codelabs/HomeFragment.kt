package com.reza.codelabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigate_action_button.setOnClickListener {
            // findNavController().navigate(R.id.dest_step_one)
            // findNavController().navigate(R.id.dest_step_one, null)
            Navigation.createNavigateOnClickListener(R.id.dest_step_one, null)
        }
    }
}
