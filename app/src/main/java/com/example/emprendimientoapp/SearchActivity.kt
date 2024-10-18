
package com.example.emprendimientoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.AccountActivity
import com.example.emprendimientoapp.CartActivity
import com.example.emprendimientoapp.DetailActivity
import com.example.emprendimientoapp.EntrepreneurshipsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Manejo de clics en las imágenes de productos (ImageButton)
        val productImage1 = findViewById<ImageButton>(R.id.product_image1)
        val productImage2 = findViewById<ImageButton>(R.id.product_image2)
        val productImage3 = findViewById<ImageButton>(R.id.product_image3)
        val productImage4 = findViewById<ImageButton>(R.id.product_image4)

        productImage1.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("product_id", 1)
            startActivity(intent)
        }

        productImage2.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("product_id", 2)
            startActivity(intent)
        }

        productImage3.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("product_id", 3)
            startActivity(intent)
        }

        productImage4.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("product_id", 4)
            startActivity(intent)
        }

        // Configuración del BottomNavigationView para manejar la navegación entre las secciones
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
