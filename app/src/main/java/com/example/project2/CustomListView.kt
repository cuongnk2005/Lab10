package com.example.project2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.project2.databinding.ActivityListViewBinding
import kotlin.Result

class CustomListView : AppCompatActivity() {
    private lateinit var biding : ActivityListViewBinding
    private var item:ArrayList<String> = ArrayList<String>()
    private lateinit var  adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(biding.root)
        item.add("Ngô Khắc Cường")
        item.add("Nguyễn Gia Kiệt")
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,item)
        biding.listview.adapter =adapter


        event()

    }
    private fun event(){
        var index: Int = -1
        biding.listview.setOnItemClickListener { parent, view, position, _  ->
            val selectedItem = item[position] // Lấy nội dung item được chọn
            biding.listview.getChildAt(index)?.setBackgroundColor(Color.WHITE)
            view.setBackgroundColor(Color.YELLOW)
            index = position
            Toast.makeText(this, "Bạn chọn: $selectedItem", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Xác nhận")
            builder.setMessage("Bạn có chắc muốn xóa không?")
            builder.setPositiveButton("Có") { dialog, _ ->
                item.removeAt(position)
                Toast.makeText(this, "Đã xóa!", Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            builder.setNegativeButton("Không") { dialog, _ ->
                dialog.dismiss()
            }
            val alertDialog = builder.create()
            alertDialog.show()
            biding.btnUpdate.setOnClickListener(){
                val fullname = biding.edtInput.text.toString().trim()
                if(TextUtils.isEmpty(fullname)){
                    Toast.makeText(this,"Bạn chưa nhập dữ liệu!",Toast.LENGTH_SHORT).show()
                } else {
                    item[position] = fullname
                    biding.edtInput.setText("")
                    adapter.notifyDataSetChanged()

                    Toast.makeText(this,"Đã cập nhật thành công",Toast.LENGTH_SHORT).show()
                }

            }

        }
        biding.btnAdd.setOnClickListener(){
            val fullname = biding.edtInput.text.toString().trim()
            if(TextUtils.isEmpty(fullname)){
              Toast.makeText(this,"Bạn chưa nhập dữ liệu!",Toast.LENGTH_SHORT).show()
            } else {
              item.add(fullname)
                biding.edtInput.setText("")

                adapter.notifyDataSetChanged()

                Toast.makeText(this,"Thêm Thành Công",Toast.LENGTH_SHORT).show()
            }
//            val intent = Intent(this,ViewAddStudent::class.java)
//            startActivity(intent)\

        }

    }
}