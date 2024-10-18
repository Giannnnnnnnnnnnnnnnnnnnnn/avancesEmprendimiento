package com.example.emprendimientoapp


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.ProductAdapter
import com.example.emprendimientoapp.SearchActivity

import com.google.android.material.bottomnavigation.BottomNavigationView

class EntrepreneurshipsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var logoImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var descriptionTextView: TextView

    // Simulación de un emprendimiento y sus productos
    private val entrepreneurship = Entrepreneurship(
        name = "ModaColombiana",
        description = "Emprendimiento de ropa artesanal colombiana con un estilo moderno y cultural.",
        logoResourceId = R.drawable.entrepreneurship_logo, // Imagen de ejemplo
        products = listOf(
            Product("Chaqueta con parches únicos", 78900, R.drawable.product1),
            Product("Bolso de cuero artesanal", 95000, R.drawable.product3)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrepreneurships)

        // Referenciar los elementos de la UI
        logoImageView = findViewById(R.id.logoImageView)
        nameTextView = findViewById(R.id.nameTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        recyclerView = findViewById(R.id.productsRecyclerView)

        // Configurar la información del emprendimiento
        logoImageView.setImageResource(entrepreneurship.logoResourceId)
        nameTextView.text = entrepreneurship.name
        descriptionTextView.text = entrepreneurship.description

        // Configurar el RecyclerView para mostrar los productos
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(entrepreneurship.products)

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
