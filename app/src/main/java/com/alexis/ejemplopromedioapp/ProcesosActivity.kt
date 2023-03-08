package com.alexis.ejemplopromedioapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProcesosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_procesos)

        val mensajeNotas = findViewById<TextView>(R.id.idNotas)
        val prom = findViewById<TextView>(R.id.promMessage)

        var miBundle: Bundle?= this.intent.extras

        if (miBundle != null){
            mensajeNotas.text="${miBundle.getString("Notas")}"
        }

        val data = miBundle!!.getString("Promedio")
        val dates = miBundle.getString("Datos")
        val result = data?.toDouble()

        val conversion = result.toString()

        if (result!! >= 3.5){
            prom.text="$dates $conversion"
            prom.setTextColor(Color.GREEN)
        } else {
            prom.text="$dates $conversion"
            prom.setTextColor(Color.RED)
        }

        val botonRegresar:Button=findViewById(R.id.btnRegresar)
        botonRegresar.setOnClickListener { onClick() }

    }

    private fun onClick() {
        finish()
    }
}