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
import com.example.project2.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
//    lateinit var result:TextView
//    lateinit var btnback:TextView
    private lateinit var biding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        setContentView(R.layout.activity_result)
        biding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(biding.root)
        Toast.makeText(this, "Đã chuyển sang SecondMainActivity", Toast.LENGTH_SHORT).show()
//        result = findViewById(R.id.resultSecond)
        val kq = intent.getStringExtra("result")
        biding.resultSecond.text = kq
//        btnback = findViewById(R.id.btnback)
        biding.btnback.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("result", "$kq")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}