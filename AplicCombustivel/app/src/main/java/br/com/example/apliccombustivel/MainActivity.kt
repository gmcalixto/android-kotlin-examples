package br.com.example.apliccombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btCalcular.setOnClickListener { view: View? ->


            try{
                var precoAlcool = txtPrecoAlcool.text.toString().toDouble()
                var precoGasolina = txtPrecoGasolina.text.toString().toDouble()

                var resultado:Double = precoAlcool/precoGasolina

                var mensagem = ""

                if(resultado > 0.7){
                    mensagem = "Gasolina"
                }
                else if(resultado < 0.7){
                    mensagem = "Álcool"
                }
                else{
                    mensagem = "Tanto faz"
                }

                //Toast.makeText(this,mensagem, Toast.LENGTH_LONG).show()

                var intentFiap = Intent(this,ResultadoActivity::class.java)

                intentFiap.putExtra("msg",mensagem)

                startActivity(intentFiap)
            }
            catch (e: NumberFormatException){
                Toast.makeText(this,"Digite um valor válido", Toast.LENGTH_LONG).show()
            }


        }


    }
}
