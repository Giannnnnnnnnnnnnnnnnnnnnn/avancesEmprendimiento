package com.example.emprendimientoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.AccountActivity
import com.example.emprendimientoapp.CartActivity
import com.example.emprendimientoapp.EntrepreneurshipsActivity
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.SearchActivity

import com.google.android.material.bottomnavigation.BottomNavigationView

class PayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Implementación del BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    // Navegar a la pantalla de inicio
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_entrepreneurships -> {
                    // Navegar a la pantalla de emprendimientos
                    val intent = Intent(this, EntrepreneurshipsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_account -> {
                    // Navegar a la pantalla de cuenta
                    val intent = Intent(this, AccountActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_cart -> {
                    // Navegar a la pantalla del carrito
                    val intent = Intent(this, CartActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
