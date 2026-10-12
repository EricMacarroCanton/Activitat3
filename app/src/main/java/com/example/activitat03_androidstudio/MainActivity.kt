package com.example.activitat03_androidstudio

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    private var altura = 100
    private var pes = 65

    private var home_selected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val card_home: MaterialCardView = findViewById(R.id.seleccio_home)
        val card_dona: MaterialCardView = findViewById(R.id.seleccio_dona)

        val colorActiu = Color.parseColor("#1D1E33")
        val colorInactiu = Color.parseColor("#151628")

        card_home.setOnClickListener {
            card_home.setCardBackgroundColor(colorActiu)
            card_dona.setCardBackgroundColor(colorInactiu)
            home_selected = true
        }

        card_dona.setOnClickListener {
            card_dona.setCardBackgroundColor(colorActiu)
            card_home.setCardBackgroundColor(colorInactiu)
            home_selected = false
        }

        val sliderAltura: Slider = findViewById(R.id.slider_altura)
        val txtAltura: TextView = findViewById(R.id.txt_altura)

        sliderAltura.addOnChangeListener { _, value, _ ->
            altura = value.toInt()
            txtAltura.text = "$altura centimeters"
        }

        val txtPes: TextView = findViewById(R.id.txt_pes)
        val btnPesMenys: Button = findViewById(R.id.btn_pes_menys)
        val btnPesMes: Button = findViewById(R.id.btn_pes_mes)

        btnPesMenys.setOnClickListener {
            if (pes > 1) {
                pes--
                txtPes.text = "$pes Kg"
            }
        }

        btnPesMes.setOnClickListener {
            if (pes < 300) {
                pes++
                txtPes.text = "$pes Kg"
            }
        }
    }
}