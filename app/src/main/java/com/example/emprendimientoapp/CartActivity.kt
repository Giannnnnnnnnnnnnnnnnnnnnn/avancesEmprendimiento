package com.example.emprendimientoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emprendimientoapp.AccountActivity
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.EntrepreneurshipsActivity
import com.example.emprendimientoapp.SearchActivity
import com.example.emprendimientoapp.PayActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var totalPriceTextView: TextView
    private lateinit var checkoutButton: Button

    private val cartItems = listOf(
        CartItem("Chaqueta con parches únicos", 78900, R.drawable.product1),
        CartItem("Gafas de sol estilo vintage", 120000, R.drawable.product2)
        // Añade más productos al carrito según sea necesario
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Referencias a los elementos de la UI
        recyclerView = findViewById(R.id.recyclerView)
        totalPriceTextView = findViewById(R.id.totalPriceTextView)
        checkoutButton = findViewById(R.id.checkoutButton)

        // Configurar el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CartAdapter(cartItems)

        // Calcular el precio total
        val totalPrice = cartItems.sumOf { it.price }
        totalPriceTextView.text = "Total: $totalPrice COP"

        // Acción del botón de checkout
        checkoutButton.setOnClickListener {
            val intent = Intent(this, PayActivity::class.java)
            startActivity(intent)
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
