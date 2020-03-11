package com.reza.codelabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        navigate_action_button.setOnClickListener {
            // findNavController().navigate(R.id.dest_step_one)
            findNavController().navigate(R.id.dest_step_one, null, options)
            // Navigation.createNavigateOnClickListener(R.id.dest_step_one, null)
        }
    }
}
