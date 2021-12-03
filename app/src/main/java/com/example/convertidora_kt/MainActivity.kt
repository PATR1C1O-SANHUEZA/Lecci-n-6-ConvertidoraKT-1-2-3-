package com.example.convertidora_kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var num: EditText? = null
    private var mens: EditText? = null
    private var mesnACT2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num = findViewById(R.id.num)
        mens = findViewById(R.id.mensTxt)
        mesnACT2 = findViewById(R.id.mesnACT2)
        val extra = intent.extras
        try {
            val mens2 = extra!!.getString("mesnACT2")
            mesnACT2!!.text = mens2
        } catch (e: Exception) {
            e.message?.let { Log.i("Error", it) }
        }
    }

    fun convierteAEuro(view: View?) {
        //valor del eruo 10/09/2021 (1 peso = 0,0011 €)
        val EURO = 0.0011f
        val numIn: Float = num!!.text.toString().toFloat()
        val res = numIn * EURO
        val intent = Intent(this, SecondMainActivity::class.java)
        intent.putExtra("numero", res)
        intent.putExtra("mens", mens!!.text.toString())
        startActivity(intent)
    }
}