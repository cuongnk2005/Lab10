package com.example.project2

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
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
        biding.btnSave.setOnClickListener(){
            var id = biding.edtInput.text.toString()
            var  name = biding.edtInputName.text.toString()
            if(TextUtils.isEmpty(id)){
                Toast.makeText(this,"Vui lòng nhập id", Toast.LENGTH_SHORT).show()
            }else if(TextUtils.isEmpty(name)){
                Toast.makeText(this,"Vui lòng nhập name", Toast.LENGTH_SHORT).show()
            }else{
                val resultIntent = Intent()
                resultIntent.putExtra("result",Student(id,name))
                setResult(RESULT_OK,resultIntent)
                finish()
            }
        }

    }
}