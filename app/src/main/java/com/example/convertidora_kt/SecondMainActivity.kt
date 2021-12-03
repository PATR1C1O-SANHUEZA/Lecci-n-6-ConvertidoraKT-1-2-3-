package com.example.convertidora_kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondMainActivity : AppCompatActivity() {
    private var mensIn: TextView? = null
    private var mensOut: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_main)
        mensIn = findViewById(R.id.mensIn)
        mensOut = findViewById(R.id.mensOut)
        val extra = intent.extras
        val mens = extra!!.getString("mens")
        val numero = extra.getFloat("numero")
        val mensajeCompleto = " El resultado en € es: $numero y el mensaje es: $mens"

        mensIn!!.text = mensajeCompleto

    }

    fun enviaMens(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("mesnACT2", mensOut!!.text.toString())
        startActivity(intent)
    }
}