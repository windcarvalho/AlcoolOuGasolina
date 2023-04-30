package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    var edGasolina:Double = 0.0;
    var edAlcool:Double = 0.0;
    var resDouble:Double = 0.0;
    resCompleto df = new DecimalFormat("#.00");
    resultadoVal=df.format(0.0000);
    
    Switch swPercentual;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")
        
        if (savedInstanceState != null){
            percentual =savedInstanceState.getDouble("percentual");
        }S
        //recuperando caso exista
        
        TextView resultado = (TextView) findViewById(R.id.resultado);
        resultado.setText("$resultadoVal");
        //texto com resultado
        
        EditText edGasolina = (EditText) findViewById(R.id.edGasolina);
        EditText edAlcool = (EditText) findViewById(R.id.edAlcool);
        String txtGasolina = edGasolina.getText().toString();
        String txtAlcool = edAlcool.getText().toString();
        edGasolina = Double.parseDouble(txtGasolina);
        edAlcool = Double.parseDouble(txtAlcool);
        //recuperando textos dos imputs e convertendo para double
        
        Switch swPercentual = (Switch) findViewById(R.id.swPercentual);
        /*O switch deve ser adicionado sempre após a set content view
          para poder ser visualizado corretamente.
          Lembrando que a funcao .isChecked() verifica se está ligado ou não
          */
        
        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            if (swPercentual.isChecked()){
                percentual=0.75;
                resDouble = edGasolina/edAlcool;
                resultadoVal=df.format(resDouble);               
                Log.d("PDM23","No btCalcular, $percentual, $resultadoVal");
                }
            else{
                percentual=0.70;
                resDouble = edGasolina/edAlcool;
                resultadoVal=df.format(resDouble);
                Log.d("PDM23","No btCalcular, $percentual, $resultadoVal");
            }
            if(resDouble>=percentual){
                    resultado.setText("Escolha gasolina $resultadoVal");
                }
                else{
                    resultado.setText("Escolha alcool $resultadoVal");
                }
        })
        //termino do botão
        
    }
override fun onResume(){
    super.onResume()
    if (savedInstanceState != null){
        percentual =savedInstanceState.getDouble("percentual");
    }
    //recuperando caso exista
    Log.d("PDM23","No onResume, $percentual")
}

override fun onStart(){
    super.onStart()
    if (savedInstanceState != null){
        percentual =savedInstanceState.getDouble("percentual");
    }
    //recuperando caso exista
    Log.d("PDM23","No onStart, $percentual")
}

override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onPause, $percentual")
    if (savedInstanceState != null){
        percentual =savedInstanceState.getDouble("percentual");
    }
    //recuperando caso exista
}

override fun onStop(savedInstanceState: Bundle?){
    super.onDestroy(savedInstanceState: Bundle?)
    super.onDestroy(savedInstanceState)
    if (savedInstanceState != null){
        percentual =savedInstanceState.getDouble("percentual");
    }
    //recuperando caso exista
    Log.d("PDM23","No onStop, $percentual")
}

override fun onDestroy(){
    super.onDestroy(savedInstanceState: Bundle?)
    super.onDestroy(savedInstanceState)
    if (savedInstanceState != null){
        percentual =savedInstanceState.getDouble("percentual");
    }
    //recuperando caso exista
    Log.d("PDM23","No onDestroy, $percentual")
}

override fun onSaveInstanceState(outState: Bundle) {
   outState.putDouble("percentual",percentual)
   super.onSaveInstanceState(outState)
}
//inicializando a função de salvar estados

}
