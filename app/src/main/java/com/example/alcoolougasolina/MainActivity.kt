package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var percentual: Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")
        }
        Log.d("PDM23", "No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            percentual = 0.75
            Log.d("PDM23", "Na Inner Class, $percentual")
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


} // fim da classe