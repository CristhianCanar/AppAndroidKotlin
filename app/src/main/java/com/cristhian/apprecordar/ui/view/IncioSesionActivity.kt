package com.cristhian.apprecordar.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.cristhian.apprecordar.databinding.ActivityIncioSesionBinding

class IncioSesionActivity : AppCompatActivity() {
    lateinit var binding: ActivityIncioSesionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIncioSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}