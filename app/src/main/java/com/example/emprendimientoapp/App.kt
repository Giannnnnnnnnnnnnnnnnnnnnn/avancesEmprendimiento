package com.example.emprendimientoapp

import android.app.Application
import com.google.firebase.FirebaseApp

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Inicializa Firebase cuando la aplicación comienza
        FirebaseApp.initializeApp(this)
    }
}
