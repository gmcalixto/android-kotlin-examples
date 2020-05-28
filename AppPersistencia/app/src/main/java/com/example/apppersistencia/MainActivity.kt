package com.example.apppersistencia

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sh = getSharedPreferences("valores", Context.MODE_PRIVATE)

        btGravar.setOnClickListener { view: View? ->

            sh.edit().putString("vl",txtValor.text.toString()).apply()
            
        }

        btMostrar.setOnClickListener { view: View? ->

            var texto = sh.getString("vl","Limpou!")

            Toast.makeText(this,texto,Toast.LENGTH_SHORT).show()

        }



    }
}
