package com.alexis.ejemplopromedioapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCalcular:Button=findViewById(R.id.btnCalcular)
        botonCalcular.setOnClickListener { realizarCalculo() }
    }

    private fun realizarCalculo() {

        val campoNombre:EditText=findViewById(R.id.idNombreTxt)
        val campoMateria:EditText=findViewById(R.id.idMateriaTxt)
        val campoNota1:EditText=findViewById(R.id.idNota1Txt)
        val campoNota2:EditText=findViewById(R.id.idNota2Txt)
        val campoNota3:EditText=findViewById(R.id.idNota3Txt)


        val nombre = campoNombre.text.toString()
        val materia = campoMateria.text.toString()

        val nota1 = campoNota1.text.toString().toDouble()
        val nota2= campoNota2.text.toString().toDouble()
        val nota3= campoNota3.text.toString().toDouble()


        var prom:Double=(nota1+nota2+nota3)/3

        val notas = """
            Nombre: $nombre, Materia: $materia
            Las notas ingresadas fueron:
            
            Nota 1: $nota1
            Nota 2: $nota2
            Nota 3: $nota3
        """.trimIndent()

        var promData = prom.toString()

        var result=""

        if (nombre.isEmpty()){
            campoNombre.error = "Nombre obligatorio"
        } else if (materia.isEmpty()){
            campoMateria.error = "Materia  obligatorio"
        } else {

        if (prom>=3.5){
            result="EL ESTUDIANTE $nombre GANÓ LA MATERIA: $materia CON UN PROMEDIO DE: "
        } else {
            result="EL ESTUDIANTE $nombre PERDIÓ LA MATERIA: $materia CON UN PROMEDIO DE: "
        }

        val miIntent = Intent(this, ProcesosActivity::class.java)
        val miBundle:Bundle = Bundle()
        miBundle.putString("Datos",  result)
        miBundle.putString("Notas", notas)
        miBundle.putString("Promedio", promData)

        miIntent.putExtras(miBundle)
        startActivity(miIntent)

        }

        campoNombre.setText("");
        campoMateria.setText("");
        campoNota1.setText("");
        campoNota2.setText("");
        campoNota3.setText("");

        /*else if (nota1Txt.isEmpty()){
            campoNota1.error = "Nota 1 obligatorio"
        } else if (nota2Txt.isEmpty()){
            campoNota2.error = "Nota 2 obligatorio"
        } else if (nota3Txt.isEmpty()){
            campoNota3.error = "Nota 3 obligatorio"
        }*/

        // mensajeResult.text="Hola $nombre usted $result"
        //Toast.makeText(this, "Hola $nombre usted $result", Toast.LENGTH_LONG).show()
    }
}