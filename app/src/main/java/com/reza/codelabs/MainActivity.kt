package com.reza.codelabs

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _1.addListener {
            val clipboardManager: ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if (clipboardManager.hasPrimaryClip()) {
                val item = clipboardManager.primaryClip!!.getItemAt(0)
                val ptext = item.text
                if (ptext.length > 3) {
                    _1.setText(ptext[0].toString())
                    _2.setText(ptext[1].toString())
                    _3.setText(ptext[2].toString())
                    _4.setText(ptext[3].toString())
                }
            }
        }
    }
}
