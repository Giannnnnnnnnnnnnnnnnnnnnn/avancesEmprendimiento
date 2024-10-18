package com.example.emprendimientoapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.EntrepreneurshipsActivity
import com.example.emprendimientoapp.SearchActivity

import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_review)

        // Recibir el ID del producto desde SearchActivity
        val productId = intent.getIntExtra("product_id", 0)

        // Referenciar los elementos de la UI
        val productImageView: ImageView = findViewById(R.id.product_image)
        val productDescriptionTextView: TextView = findViewById(R.id.product_description)
        val productPriceTextView: TextView = findViewById(R.id.product_price)

        // Simulación de datos según el producto seleccionado
        when (productId) {
            1 -> {
                productImageView.setImageResource(R.drawable.product1)
                productDescriptionTextView.text = "Chaqueta con parches únicos"
                productPriceTextView.text = "78,900 COP"
            }
            2 -> {
                productImageView.setImageResource(R.drawable.product2)
                productDescriptionTextView.text = "Gafas de sol estilo vintage"
                productPriceTextView.text = "120,000 COP"
            }
            3 -> {
                productImageView.setImageResource(R.drawable.product3)
                productDescriptionTextView.text = "Bolso de cuero artesanal"
                productPriceTextView.text = "95,000 COP"
            }
            4 -> {
                productImageView.setImageResource(R.drawable.product4)
                productDescriptionTextView.text = "Zapatos deportivos ecológicos"
                productPriceTextView.text = "150,000 COP"
            }
            else -> {
                productImageView.setImageResource(R.drawable.default_product)
                productDescriptionTextView.text = "Producto no encontrado"
                productPriceTextView.text = "N/A"
            }
        }

        // Botón OK para ir a la siguiente actividad
        val buttonOk: Button = findViewById(R.id.buttonOk)
        buttonOk.setOnClickListener {
            val intent = Intent(this, Detaail2Activity::class.java)
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
