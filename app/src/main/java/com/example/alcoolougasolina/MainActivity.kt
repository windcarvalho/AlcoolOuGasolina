package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var percentual: Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")

        Log.d("PDM23", "No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            val mySwitch = findViewById<Switch>(R.id.swPercentual);
            val alcoholEditText = findViewById<EditText>(R.id.edAlcool);
            val isAlcoholEditTextEmpty = checkIfIsEmpty(alcoholEditText);
            val gasEditText = findViewById<EditText>(R.id.edGasolina);
            val isGasEditTextEmpty = checkIfIsEmpty(gasEditText);

            if(!isAlcoholEditTextEmpty || !isGasEditTextEmpty)
                return@OnClickListener;
            if (mySwitch.isChecked)
                setPercentual(0.75);

            val gasValue = getFloatValueFromEditText(gasEditText);
            val alcoholValue = getFloatValueFromEditText(alcoholEditText);
            val alcoholbyGasValue : Double = alcoholValue/gasValue;
            val p = getPercentual();
            if(alcoholbyGasValue <= getPercentual())
                Toast.makeText(this,"Valor do Álcool é rentável",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Valor da Gasolina é rentável",Toast.LENGTH_SHORT).show();

         ///   Log.d("PDM23", "VALOR DO Percentual $gasValue");
          //  Log.d("PDM23", "VALOR DO Percentual $alcoholValue");
            Log.d("PDM23", "No btCalcular, $percentual");
        })

        }

    override fun onResume() {
        super.onResume()
        Log.d("PDM23", "No onResume, $percentual")
    }

    override fun onStart() {
        super.onStart()
        Log.d("PDM23", "No onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("PDM23", "No onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PDM23", "No onStop")
    }
    private fun checkIfIsEmpty(editText: EditText) : Boolean{
        try{
            if (editText.text.toString().trim().isEmpty()) {
                editText.error = "Este campo é obrigatório";
                return false;
            }
            return true;
        }catch (e : Exception){
            return false;
        }
    }
    private fun getFloatValueFromEditText(editText: EditText) : Double{
        try{
            val editText = editText.text.toString();
            return editText.toDouble();
        }catch (e : Exception){
            Log.d("PDM23", "Ocorreu um erro ao obter valor da variável");
            return 0.0;
        }
    }
    fun setPercentual(novoNumero: Double) {
        percentual = novoNumero
    }

    fun getPercentual() : Double {
        return percentual;
    }
    override fun onResume() {
        super.onResume()
        Log.d("PDM23", "No onResume, $percentual")
    }

    override fun onStart() {
        super.onStart()
        Log.d("PDM23", "No onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("PDM23", "No onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PDM23", "No onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PDM23", "No onDestroy")
    }
     fun onClickBtCalcular(v: View) {
        //código do evento
        percentual = 0.75
        Log.d("PDM23", "No onClik, $percentual")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("percentual",percentual)
        super.onSaveInstanceState(outState)
    }
}
   
