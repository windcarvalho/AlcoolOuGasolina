package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var edAlcool: EditText
    private lateinit var edGasolina: EditText
    private lateinit var swPercentual: Switch
    private lateinit var btCalc: Button

    private var percentual: Double = 0.7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23", "No onCreate, $percentual")

        // Inicialize as views
        edAlcool = findViewById(R.id.edAlcool)
        edGasolina = findViewById(R.id.edGasolina)
        swPercentual = findViewById(R.id.swPercentual)
        btCalc = findViewById(R.id.btCalcular)

        // Recupere o valor do percentual se estiver disponível
        if (savedInstanceState != null) {
            percentual = savedInstanceState.getDouble("percentual")
            swPercentual.isChecked = percentual == 0.75
        }

        btCalc.setOnClickListener(View.OnClickListener {
            calcularMelhorCombustivel()
        })

        swPercentual.setOnCheckedChangeListener { _, isChecked ->
            percentual = if (isChecked) 0.75 else 0.7
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("percentual", percentual)
    }

    private fun calcularMelhorCombustivel() {
        val alcoolPrice = edAlcool.text.toString().toDoubleOrNull()
        val gasolinaPrice = edGasolina.text.toString().toDoubleOrNull()

        if (alcoolPrice != null && gasolinaPrice != null) {
            val razao = alcoolPrice / gasolinaPrice

            val mensagem = if (razao <= percentual) {
                "Melhor utilizar álcool"
            } else {
                "Melhor utilizar gasolina"
            }

            val tvResultado = findViewById<TextView>(R.id.tvResultado)
            tvResultado.text = mensagem
        } else {
            val tvResultado = findViewById<TextView>(R.id.tvResultado)
            tvResultado.text = "Insira o preço dos combustíveis"
        }
    }
    override fun onResume(){
        super.onResume()
        Log.d("PDM23","No onResume, $percentual")
    }
    override fun onStart(){
        super.onStart()
        Log.d("PDM23","No onStart")
    }
    override fun onPause(){
        super.onPause()
        Log.d("PDM23","No onPause")
    }
    override fun onStop(){
        super.onStop()
        Log.d("PDM23","No onStop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("PDM23","No onDestroy")
    }
}
