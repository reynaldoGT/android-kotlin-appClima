package com.example.climaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvCiudad:TextView? = null
        var tvGrados:TextView? = null
        var tvEstatus:TextView? = null


        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstado)


        val ciudad = intent.getStringExtra("xd")
        var Url :String="https://api.openweathermap.org/data/2.5/weather?id=3435910&appid=1df4b54c2551746c00253fd4a88eedb4"

        if(VerRed.hayRed(this)){
            //ejecutar la solicitud http

            //solitcitidWithVolley("https://api.openweathermap.org/data/2.5/weather?id=3435910&appid=1df4b54c2551746c00253fd4a88eedb4")
            //key : 1df4b54c2551746c00253fd4a88eedb4
            //la paz id 3911925

            if(ciudad=="ciudad-lapaz"){
                Ciudad_id("3911925")

            }else if(ciudad=="ciudad-berlin"){
                Ciudad_id("2950159")
            }else if(ciudad=="ciudad-elalto"){

                Ciudad_id("3941584")
            }else if(ciudad=="ciudad-BA"){

                Ciudad_id("3435910")
            }else{
                Toast.makeText(this,"no se encontro la ciudad",Toast.LENGTH_LONG).show()
            }


        }else{
            println("no hay red")
            Log.d("no hay red","no se encontro la red")
        }

    }



    private  fun solitcitidWithVolley(url:String) {
        var URL ="https://api.openweathermap.org/data/2.5/weather?id=3435910&appid=1df4b54c2551746c00253fd4a88eedb4&units=metric&lang=es"

        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener <String>{
                response ->
            try {
                Log.d("solicitud por volley",response)
                //usando la libreria gson para parsear
                val gson = Gson()
                val ciudad = gson.fromJson(response,Ciudad::class.java)

                tvCiudad?.text=ciudad.name

                tvGrados.text=(ciudad.main?.temp).toString()+"°"
                tvEstado.text=ciudad.weather?.get(0)?.description

                //validando para los campos
                val ciudad_Intent = intent.getStringExtra("xd")

            }catch (e: Exception){

            }
        }, Response.ErrorListener {
                error ->
            Log.d("solicitud por volley",error.message)

        })
        queue.add(solicitud)

    }





    private  fun Ciudad_id(id:String) {
        var URL ="https://api.openweathermap.org/data/2.5/weather?id=$id&appid=1df4b54c2551746c00253fd4a88eedb4&units=metric&lang=es"

        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, URL, Response.Listener <String>{
                response ->
            try {
                Log.d("solicitud por volley",response)
                //usando la libreria gson para parsear
                val gson = Gson()
                val ciudad = gson.fromJson(response,Ciudad::class.java)

                tvCiudad?.text=ciudad.name
                tvGrados.text=ciudad.main?.temp.toString()+"°"
                tvEstado.text=ciudad.weather?.get(0)?.description

                //validando para los campos
                val ciudad_Intent = intent.getStringExtra("xd")

            }catch (e: Exception){

            }
        }, Response.ErrorListener {
                error ->
            Log.d("solicitud por volley",error.message)

        })
        queue.add(solicitud)

    }


    fun verCiudad(id:String){

    }

}
