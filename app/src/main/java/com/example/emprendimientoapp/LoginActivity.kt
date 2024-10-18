package com.example.emprendimientoapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.SearchActivity
import com.example.emprendimientoapp.RegisterActivity

import com.example.emprendimientoapp.R
import com.google.android.gms.auth.api.Auth
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        auth.signInWithEmailAndPassword(
            etEmail.toString(),
            etPassword.toString()
        ).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                FirebaseAuth.getInstance().currentUser
            } else {
task.exception
            }
        }



        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)

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