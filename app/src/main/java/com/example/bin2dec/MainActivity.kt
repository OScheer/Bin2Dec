package com.example.bin2dec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private fun convertBinToDec(bin: Long): Int {
        var bin = bin
        var dec = 0
        var i = 0
        var remain: Long

        while (bin.toInt() != 0) {
            remain = bin % 10
            bin /= 10
            dec += (remain * 2.0.pow(i.toDouble())).toInt()
            ++i
        }
        return dec
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        inputText.validate("No Binary Number") { input -> input.isValidBinary() }

        confirm_button.setOnClickListener {
            if (inputText.text.toString().trim().isNotEmpty()) {
                val inputBin = inputText.text.toString().toLong()
                outputBinText.text = inputBin.toString()
                outputDecText.text = convertBinToDec(inputBin).toString()
                inputText.text.clear()
            } else {
                Toast.makeText(this, "Binary Input is Empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}