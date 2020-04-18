package com.reza.codelabs.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.reza.codelabs.R
import com.reza.codelabs.ui.detail.DetailMovie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            val intent = Intent(this, DetailMovie::class.java)
            intent.putExtra("id", 299534)
            startActivity(intent)
        }
    }
}
