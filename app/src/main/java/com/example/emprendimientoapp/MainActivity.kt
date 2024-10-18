package com.example.emprendimientoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

    import android.content.Intent

    import android.os.Handler
    import android.os.Looper
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.SecondActivity

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Retardo de 3 segundos antes de pasar a la pantalla principal
            Handler(Looper.getMainLooper()).postDelayed({
                // Iniciar la actividad principal (MainActivity)
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                finish() // Finaliza la SplashActivity para no volver atrás
            }, 3000) // 3 segundos de retardo
        }
    }
