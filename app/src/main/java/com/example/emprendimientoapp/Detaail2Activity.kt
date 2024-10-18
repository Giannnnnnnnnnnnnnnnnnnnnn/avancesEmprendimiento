package com.example.emprendimientoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.AccountActivity
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.EntrepreneurshipsActivity
import com.example.emprendimientoapp.SearchActivity

import com.example.emprendimientoapp.PayActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Detaail2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        // Recibir el ID del producto desde la actividad anterior
        val productId = intent.getIntExtra("product_id", 0)

        // Referenciar la imagen del producto
        val productImageView: ImageView = findViewById(R.id.product_image)

        // Referenciar otros elementos (nombre del producto, dirección, emprendimiento)
        val productNameTextView: TextView = findViewById(R.id.product_name)
        val productEntrepreneurshipTextView: TextView = findViewById(R.id.product_entrepreneurship)
        val productPriceTextView: TextView = findViewById(R.id.product_price)
        val productAddressEditText: EditText = findViewById(R.id.product_address)

        // Mostrar la información del producto según el productId
        when (productId) {
            1 -> {
                productImageView.setImageResource(R.drawable.product1)
                productNameTextView.text = "Chaqueta con parches únicos"
                productEntrepreneurshipTextView.text = "Hecho por: ModaColombiana"
                productPriceTextView.text = "78,900 COP"
            }
            2 -> {
                productImageView.setImageResource(R.drawable.product2)
                productNameTextView.text = "Gafas de sol estilo vintage"
                productEntrepreneurshipTextView.text = "Hecho por: SolArt"
                productPriceTextView.text = "120,000 COP"
            }
            3 -> {
                productImageView.setImageResource(R.drawable.product3)
                productNameTextView.text = "Bolso de cuero artesanal"
                productEntrepreneurshipTextView.text = "Hecho por: CueroTradición"
                productPriceTextView.text = "95,000 COP"
            }
            4 -> {
                productImageView.setImageResource(R.drawable.product4)
                productNameTextView.text = "Zapatos deportivos ecológicos"
                productEntrepreneurshipTextView.text = "Hecho por: EcoStep"
                productPriceTextView.text = "150,000 COP"
            }
            else -> {
                productImageView.setImageResource(R.drawable.default_product)
                productNameTextView.text = "Producto no encontrado"
                productEntrepreneurshipTextView.text = "N/A"
                productPriceTextView.text = "N/A"
            }
        }

        // Botón para proceder a la pantalla de pago
        val buttonComprar: Button = findViewById(R.id.ButtonComprar)
        buttonComprar.setOnClickListener {
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
