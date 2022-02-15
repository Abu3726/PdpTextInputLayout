package com.conamobile.textinputlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText: EditText = findViewById(R.id.editText)
        val editText2: EditText = findViewById(R.id.editText2)
        val keyListener: Button = findViewById(R.id.key_listener)
        val textchange: TextView = findViewById(R.id.textchange)
        val text = "Nurmuhammad"

        editText2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                textchange.text = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        editText.setOnKeyListener { view, i, keyEvent ->
            if (editText.text.toString() == text) {
                //Perform Code
                    keyListener.visibility = View.VISIBLE
                Toast.makeText(this, "Key True", Toast.LENGTH_SHORT).show()
                return@setOnKeyListener true
                true
            } else {
                keyListener.visibility = View.GONE
                Toast.makeText(this, "Key False", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }
}