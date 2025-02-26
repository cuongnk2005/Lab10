package com.example.project2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Result : AppCompatActivity() {
    lateinit var result:TextView
    lateinit var btnback:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        Toast.makeText(this, "Đã chuyển sang SecondMainActivity", Toast.LENGTH_SHORT).show()
        result = findViewById(R.id.resultSecond)
        val kq = intent.getStringExtra("result")
        result.text = kq
        btnback = findViewById(R.id.btnback)
        btnback.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("result", "$kq")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}