package com.example.emprendimientoapp

import com.example.emprendimientoapp.Product

data class Entrepreneurship(
    val name: String,
    val description: String,
    val logoResourceId: Int,
    val products: List<Product>
)
