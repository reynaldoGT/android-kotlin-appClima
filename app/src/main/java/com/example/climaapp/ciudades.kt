package com.example.climaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ciudades.*

class ciudades : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)


        val TAG = "xd"


        val Bla_paz = findViewById<Button>(R.id.btn_lp)
        val Bberlin = findViewById<Button>(R.id.btn_berlin)
        val bElAlto=findViewById<Button>(R.id.btnEl_Alto)
        val BBuenosAires = findViewById<Button>(R.id.btn_B_A)

        Bla_paz.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"ciudad-lapaz")
            startActivity(intent)
        })

        Bberlin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"ciudad-berlin")
            startActivity(intent)
        })

        bElAlto.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"ciudad-elalto")
            startActivity(intent)
        })

        BBuenosAires.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"ciudad-BA")
            startActivity(intent)
        })
    }
}
