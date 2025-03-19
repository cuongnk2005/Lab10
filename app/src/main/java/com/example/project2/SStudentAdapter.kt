package com.example.project2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SStudentAdapter(private val students: ArrayList<Student>) : RecyclerView.Adapter<SStudentAdapter.StudentViewHolder>() {

        // ViewHolder giữ các thành phần UI của item
        class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvName: TextView = itemView.findViewById(R.id.studentId)
            val tvAge: TextView = itemView.findViewById(R.id.studentName)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
            return StudentViewHolder(view)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            val student = students[position]
            holder.tvName.text = student.id
            holder.tvAge.text = student.fullname
        }

        override fun getItemCount(): Int {
            return students.size
        }
    }
