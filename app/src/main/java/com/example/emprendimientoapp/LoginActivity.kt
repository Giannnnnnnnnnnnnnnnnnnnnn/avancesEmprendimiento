package com.example.emprendimientoapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.SearchActivity
import com.example.emprendimientoapp.RegisterActivity

import com.example.emprendimientoapp.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    val btnEnter: Button = findViewById(R.id.btnLogin)
    btnEnter.setOnClickListener{
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)

    }
        val btnEnterr: Button = findViewById(R.id.btnRegister)
        btnEnterr.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }
}}