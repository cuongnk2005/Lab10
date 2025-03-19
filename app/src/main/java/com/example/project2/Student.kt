package com.example.project2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.io.Serializable

class Student(var id:String, var fullname:String) : Serializable {

}

class StudentAdapter(context: Context, students: ArrayList<Student>) :
    ArrayAdapter<Student>(context, 0, students) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.student_view, parent, false)

        val student = getItem(position)
        val tvStudentInfo = view.findViewById<TextView>(R.id.tvStudentInfo)

        student?.let {
            tvStudentInfo.text = "${it.id} - ${it.fullname}"
        }

        return view
    }
}