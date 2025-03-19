package com.example.project2

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.project2.databinding.ActivityAdvanceViewBinding

class AdvanceView : AppCompatActivity() {
    private lateinit var binding: ActivityAdvanceViewBinding
    private lateinit var stadapter: StudentAdapter
    private  var studentList : ArrayList<Student> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvanceViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentList.add(Student("1","Ngô Khắc Cường"))
        studentList.add(Student("2","Ngô Khắc Việt"))
        stadapter = StudentAdapter(this,studentList)
        binding.listview.adapter = stadapter
        event()

    }
    private fun event(){
        val resultLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                var kq =  result.data?.getSerializableExtra("result")as?Student
                kq?.let {
                    studentList.add(kq)
                    stadapter.notifyDataSetChanged()
                }

            }

        }
        binding.btnAdd.setOnClickListener(){
            val intent = Intent(this,ViewAddStudent::class.java)
            resultLaunch.launch(intent)
        }
        binding.btnBack.setOnClickListener(){
            val intent = Intent(this, CustomListView::class.java)
            startActivity(intent)
        }
    }
}