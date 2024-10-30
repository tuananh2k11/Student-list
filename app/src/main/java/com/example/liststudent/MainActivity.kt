package com.example.liststudent

import Student
import StudentAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: StudentAdapter
    private val students = listOf(
        Student("Nguyen Van A", "20241234"),
        Student("Tran Thi B", "20241342"),
        Student("Le Van C", "20241423"),
        Student("Pham Thi D", "20241314"),
        Student("Quach Van E", "20245678"),
        Student("Lo Thi F", "20245768"),
        Student("Cao Van G", "20245867"),
        Student("Phung Thanh H", "20248765")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etSearch = findViewById<EditText>(R.id.etSearch)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Khởi tạo Adapter và thiết lập cho RecyclerView
        adapter = StudentAdapter(students)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Lắng nghe sự thay đổi của EditText
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }
}