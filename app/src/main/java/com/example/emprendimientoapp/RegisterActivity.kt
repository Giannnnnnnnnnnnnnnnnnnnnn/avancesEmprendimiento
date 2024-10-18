package com.example.emprendimientoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.LoginActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Referencias a los elementos de la UI
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        registerButton = findViewById(R.id.registerButton)

        // Acción del botón de registro
        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()
            auth = Firebase.auth

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign up success, update UI with the signed-in user
                        val user = auth.currentUser
                        // Aquí puedes actualizar la UI o navegar a otra actividad
                        updateUI(user)
                    } else {
                        // If sign up fails, display a message to the user
                        val errorMessage = task.exception?.message
                        Toast.makeText(baseContext, "Error: $errorMessage", Toast.LENGTH_SHORT)
                            .show()
                        // Aquí puedes manejar el error según lo necesites
                    }
                }


            // Validación básica de los campos
            if (name.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT)
                    .show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí podrías agregar lógica para registrar el usuario en una base de datos
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                // Redirigir al usuario a la pantalla de inicio de sesión después del registro
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            // Por ejemplo, redirigir a la pantalla principal
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Opcional, para cerrar la actividad de registro
        }
    }
}

