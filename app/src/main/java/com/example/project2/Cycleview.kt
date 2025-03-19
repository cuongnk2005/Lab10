package com.example.project2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2.databinding.ActivityCycleviewBinding

class Cycleview : AppCompatActivity() {
    private lateinit var binding:ActivityCycleviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityCycleviewBinding.inflate(layoutInflater)
        var students : ArrayList<Student>  = ArrayList()
        students.add(Student("1","ngo khac cuong"))
        students.add(Student("2","ngo khac cuong"))
        students.add(Student("3","ngo khac cuong"))
        students.add(Student("4","ngo khac cuong"))

        setContentView(binding.root)
        binding.recycleview.layoutManager = LinearLayoutManager(this)
        binding.recycleview.adapter = SStudentAdapter(students)
    }
}