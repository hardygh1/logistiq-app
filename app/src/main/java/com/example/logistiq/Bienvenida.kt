package com.example.logistiq

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        var correo=findViewById<TextView>(R.id.correo_usuario)
        var proveedor=findViewById<TextView>(R.id.proveedor_servicio)
        var boton_salir=findViewById<Button>(R.id.boton_salir)

        var intent=getIntent()
        correo.text="Correo: "+intent.getStringExtra("Correo")
        proveedor.text="Proveedor: "+intent.getStringExtra("Proveedor")

        boton_salir.setOnClickListener{
            var intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

            borrar_sesion()
        }
    }

    fun borrar_sesion(){
        var borrar_sesion:SharedPreferences.Editor=this.getSharedPreferences(MainActivity.Global.preferencias_compartidas,Context.MODE_PRIVATE).edit()
        borrar_sesion.clear()
        borrar_sesion.apply()
        borrar_sesion.commit()

        Firebase.auth.signOut()
    }
}