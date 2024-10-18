package com.example.emprendimientoapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.CartActivity
import com.example.emprendimientoapp.EditAccountActivity
import com.example.emprendimientoapp.EntrepreneurshipsActivity
import com.example.emprendimientoapp.SearchActivity
import com.example.emprendimientoapp.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AccountActivity : AppCompatActivity() {

    private lateinit var userNameTextView: TextView
    private lateinit var userEmailTextView: TextView
    private lateinit var userAddressTextView: TextView
    private lateinit var editButton: Button
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Referencias a los elementos de la UI
        userNameTextView = findViewById(R.id.userNameTextView)
        userEmailTextView = findViewById(R.id.userEmailTextView)
        userAddressTextView = findViewById(R.id.userAddressTextView)
        editButton = findViewById(R.id.editButton)
        logoutButton = findViewById(R.id.logoutButton)

        // Simulación de datos del usuario
        val userName = "Juan Pérez"
        val userEmail = "juan.perez@example.com"
        val userAddress = "Calle 123, Bogotá, Colombia"

        // Configuración de la información del usuario
        userNameTextView.text = userName
        userEmailTextView.text = userEmail
        userAddressTextView.text = userAddress

        // Acción del botón Editar
        editButton.setOnClickListener {
            val intent = Intent(this, EditAccountActivity::class.java)
            startActivity(intent)
        }

        // Acción del botón Cerrar sesión
        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

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
