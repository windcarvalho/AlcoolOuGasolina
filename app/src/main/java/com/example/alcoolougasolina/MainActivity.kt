package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    Switch swPercentual;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")
        Switch swPercentual = (Switch) findViewById(R.id.swPercentual);
        /*O switch deve ser adicionado sempre após a set content view
          para poder ser visualizado corretamente.
          Lembrando que a funcao .isChecked() verifica se está ligado ou não
          */
        swPercentual.setTextOn("75%");
        swPercentual.setTextOff("70%");
        //textos para on e off
        
        swPercentual.getChecked(true);
        //setando ele como ligado
        swPercentual.getChecked(false);
        //setando ele como desligado
        
        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            if (swPercentual.isChecked()){
                percentual=0.75
                Log.d("PDM23","No btCalcular, $percentual")
                statusSwitch1 = simpleSwitch1.getTextOn().toString();
                }
            else{
                
            }
        })
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onResume")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onResume")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onResume")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","No onResume")
}
}
