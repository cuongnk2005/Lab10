package com.example.project2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project2.databinding.ActivityViewAddStudentBinding

class ViewAddStudent : AppCompatActivity() {
    private lateinit var biding : ActivityViewAddStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityViewAddStudentBinding.inflate(layoutInflater)
        setContentView(biding.root)

    }
}