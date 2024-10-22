package com.example.emprendimientoapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class AccountActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Inicializar Firebase Auth y Firestore
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Referencias a los TextView en el layout
        nameTextView = findViewById(R.id.userNameTextView)
        emailTextView = findViewById(R.id.userEmailTextView)

        // Obtener el usuario actual
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null) {
            // Mostrar email del usuario desde FirebaseAuth
            emailTextView.text = currentUser.email

            // Obtener datos adicionales del usuario desde Firestore
            val userId = currentUser.uid
            db.collection("users").document(userId).get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        val name = document.getString("name")  // Asume que tienes un campo "name" en Firestore
                        if (!name.isNullOrEmpty()) {
                            nameTextView.text = name
                        } else {
                            nameTextView.text = "Nombre no disponible"
                        }
                    } else {
                        Toast.makeText(this, "No se encontraron datos de usuario", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error al obtener los datos del usuario: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(this, "No hay ningún usuario autenticado", Toast.LENGTH_SHORT).show()
        }
    }
}
