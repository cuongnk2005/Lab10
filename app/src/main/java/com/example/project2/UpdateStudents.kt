package com.example.project2

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project2.databinding.ActivityUpdateStudentsBinding

class UpdateStudents : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateStudentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener(){
            var fullname = binding.edtInput.text.toString()
            if(TextUtils.isEmpty(fullname)){
                Toast.makeText(this,"Vui lòng nhập tên", Toast.LENGTH_SHORT).show()
            }else {
                var resultIntent = Intent()
                resultIntent.putExtra("result",fullname)
                setResult(RESULT_OK,resultIntent)
                finish()
            }
        }

    }
}