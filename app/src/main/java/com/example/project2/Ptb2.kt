package com.example.project2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class Ptb2 : AppCompatActivity() {
    lateinit var edita: EditText
    lateinit var editb: EditText
    lateinit var editc: EditText
    lateinit var btnCarculator: Button
    lateinit var btndelete: Button
    lateinit var result: TextView
    lateinit var resultlauch:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ptb2)
        control()
        resultlauch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ results ->
            if(results.resultCode == RESULT_OK){
                val kq = results.data?.getStringExtra("result")
                Toast.makeText(this, "đã chuyển sang mainActivity", Toast.LENGTH_SHORT).show()
                result.text = "$kq"
            }
        }
        events()

//        dùng intent trực tiếp
//        val kq = intent.getStringExtra("result")
//        if(kq!= null){
//            Toast.makeText(this, "đã chuyển sang mainActivity", Toast.LENGTH_SHORT).show()
//            result.text = "$kq"
//        }

    }
    private fun control(){
        edita = findViewById(R.id.edita)
        editb = findViewById(R.id.editb)
        editc = findViewById(R.id.editc)
        btnCarculator = findViewById(R.id.btncarculartor)
        btndelete = findViewById(R.id.btnxoa)
        result = findViewById(R.id.result)
    }
    private fun events(){
        btnCarculator.setOnClickListener() {
            if (edita.text.toString() == "") {
                Toast.makeText(this, "vui lòng nhập số a", Toast.LENGTH_SHORT).show()
            } else if (editb.text.toString() == "") {
                Toast.makeText(this, "vui lòng nhập số b", Toast.LENGTH_SHORT).show()
            } else if (editc.text.toString() == "") {
                Toast.makeText(this, "vui lòng nhập số c", Toast.LENGTH_SHORT).show()
            } else {
                val a = edita.text.toString().toDouble()
                val b = editb.text.toString().toDouble()
                val c = editc.text.toString().toDouble()

                var intent = Intent(this, Result::class.java)
                val delta = b * b - 4 * a * c
                if (delta > 0) {
                    val x1 = (-b + sqrt(delta)) / (2 * a)
                    val x2 = (-b - sqrt(delta)) / (2 * a)
                    intent.putExtra("result", "x1 = $x1  \n" +
                            " x2 = $x2")
                } else if (delta == 0.0) {
                    val x = -b / (2 * a)
                    intent.putExtra("result", "$x")
                } else {
                    intent.putExtra("result", "phương trình vô nghiệm")
                }
                resultlauch.launch(intent)
            }
        }
        btndelete.setOnClickListener() {
            edita.text = null
            editb.text = null
            editc.text = null
            result.text = "result"
        }
    }

}