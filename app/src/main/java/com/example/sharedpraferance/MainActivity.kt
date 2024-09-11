package com.example.sharedpraferance

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpraferance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("note",Context.MODE_PRIVATE)

        binding.addbtn.setOnClickListener {
            val note=binding.net.text.toString()
            val editor=sharedPreferences.edit()

            editor.putString("note", note)
            editor.apply()

            Toast.makeText(this,"Note added", Toast.LENGTH_SHORT).show()
            binding.net.text.clear()
        }
        binding.disbtn.setOnClickListener {
            val note = sharedPreferences.getString("note",null)
        binding.txt.text=note
        }
    }
}