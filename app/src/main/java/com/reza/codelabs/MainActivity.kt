package com.reza.codelabs

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.reza.codelabs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var handler: MainActivityClickHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.student = Student("reza", "agustiana@reza.web.id")

        handler = MainActivityClickHandler(this)
        binding.clickHandler = handler

        binding.contact = Contact(8, "Reza Agustiana", "+6281515888872")
    }

    inner class MainActivityClickHandler(val context: Context) {

        fun onEnrollButtonClicked(view: View) {
            Toast.makeText(context, "Enroll Clicked", Toast.LENGTH_LONG).show()
        }

        fun onCancelButtonClicked(view: View) {
            Toast.makeText(context, "Cancel Clicked", Toast.LENGTH_LONG).show()
        }
    }
}
