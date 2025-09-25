package com.example.lab_week_03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// 1. Definisikan interface di sini
interface CoffeeListener {
    fun onSelected(id: Int)
}

// 2. Implementasikan interface tersebut
class MainActivity : AppCompatActivity(), CoffeeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 3. Override fungsi dari interface
    override fun onSelected(id: Int) {
        // Cari DetailFragment berdasarkan ID-nya di layout
        val detailFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_detail) as? DetailFragment

        // Panggil fungsi di dalam DetailFragment untuk update UI
        detailFragment?.setCoffeeData(id)
    }
}