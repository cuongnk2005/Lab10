package com.example.project2

import android.content.ClipData.Item
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.project2.databinding.ActivityListViewBinding
import kotlin.Result

class CustomListView : AppCompatActivity() {
    private lateinit var biding : ActivityListViewBinding
    private var items:ArrayList<String> = ArrayList<String>()
    private lateinit var  adapter: ArrayAdapter<String>
    private lateinit var resultLauncher:ActivityResultLauncher<Intent>
    private  var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        biding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(biding.root)
        items.add("Ngô Khắc Cường")
        items.add("Nguyễn Gia Kiệt")
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        biding.listview.adapter =adapter

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
            if(result.resultCode == RESULT_OK){
                var kq = result.data?.getStringExtra("result").toString()
                items[position] = kq
                adapter.notifyDataSetChanged()
            }
        }


        event()

    }
    private fun event(){
        var index: Int = -1
        biding.listview.setOnItemClickListener { parent, view, position, _  ->
            val selectedItem = items[position] // Lấy nội dung item được chọn
            biding.listview.getChildAt(index)?.setBackgroundColor(Color.WHITE)
            view.setBackgroundColor(Color.YELLOW)
            index = position
//            Toast.makeText(this, "Bạn chọn: $selectedItem", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Xác nhận")
            builder.setMessage("Bạn có chắc muốn xóa không?")
//           builder.setPositiveButton("Có") { dialog,  _ ->
//                item.removeAt(position)
//                Toast.makeText(this, "Đã xóa!", Toast.LENGTH_SHORT).show()
//                adapter.notifyDataSetChanged()
//                dialog.dismiss()
//            }
//            builder.setNegativeButton("Không") { dialog, _ ->
//                dialog.dismiss()
//            }
//            val alertDialog = builder.create()
//            alertDialog.show()
            showPopupMenu(view,position)
            biding.btnUpdate.setOnClickListener(){
                val fullname = biding.edtInput.text.toString().trim()
                if(TextUtils.isEmpty(fullname)){
                    Toast.makeText(this,"Bạn chưa nhập dữ liệu!",Toast.LENGTH_SHORT).show()
                } else {
                    items[position] = fullname
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
              items.add(fullname)
                biding.edtInput.setText("")

                adapter.notifyDataSetChanged()

                Toast.makeText(this,"Thêm Thành Công",Toast.LENGTH_SHORT).show()
            }
//            val intent = Intent(this,ViewAddStudent::class.java)
//            startActivity(intent)\

        }
        biding.btnAdvance.setOnClickListener(){
            val intent = Intent(this,AdvanceView::class.java)
            startActivity(intent)
        }

    }
    private fun showPopupMenu(view: View,position:Int){
    val  popumenu = PopupMenu(this,view)
        val interflate:MenuInflater = popumenu.menuInflater
        interflate.inflate(R.menu.pop_menu,popumenu.menu)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popumenu.setForceShowIcon(true) // Hiển thị icon nếu có
            popumenu.gravity = Gravity.END // Căn menu về bên phải
        }
        popumenu.setOnMenuItemClickListener { item: MenuItem ->
            when(item.itemId){
               R.id.edit -> {
                   setUpdate(position)
                   true
               }
                R.id.delete -> {
                    items.removeAt(position)
                Toast.makeText(this, "Đã xóa!", Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
                    true
                }
                else -> {
                    Toast.makeText(this, " không chọn gì", Toast.LENGTH_SHORT).show()
                    true
                }
            }


        }
        popumenu.show()
    }
    private fun setUpdate(position: Int){
        this.position = position
        val intent = Intent(this,UpdateStudents::class.java)
        resultLauncher.launch(intent)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.setting -> {
                Toast.makeText(this, "Nhấn vào Cài đặt", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.option -> {
                Toast.makeText(this, "Nhấn vào Giới thiệu", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}