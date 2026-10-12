package com.example.activitat03_androidstudio

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textCategory: TextView = findViewById(R.id.text_category)
        val textValue: TextView = findViewById(R.id.text_value)
        val textDescription: TextView = findViewById(R.id.text_description)
        val btnRecalculate: Button = findViewById(R.id.Recalculate)

        val imc = intent.getDoubleExtra("IMC", 0.0)
        textValue.text = String.format("%.2f", imc)

        val categoria: String
        val descripcio: String
        val color: String

        when {
            imc < 18.5 -> {
                categoria = "UNDERWEIGHT"
                descripcio = "UNDERWEIGHT"
                color = "#3498DB"
            }
            imc < 25 -> {
                categoria = "NORMAL"
                descripcio = "Normal"
                color = "#2ECC71"
            }
            imc < 30 -> {
                categoria = "OVERWEIGHT"
                descripcio = "Overwight"
                color = "#F39C12"
            }
            else -> {
                categoria = "OBESE"
                descripcio = "Obese"
                color = "#E74C3C"
            }
        }

        textCategory.text = categoria
        textCategory.setTextColor(Color.parseColor(color))
        textDescription.text = descripcio

        btnRecalculate.setOnClickListener {
            finish()
        }
    }
}