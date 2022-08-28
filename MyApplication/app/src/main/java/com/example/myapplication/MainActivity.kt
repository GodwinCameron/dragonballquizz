package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //sets XML frontend to be used


        binding.btnStart.setOnClickListener {

            val username = binding.etUsername.text
            if(username.toString() == ""){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, MainMenu::class.java)
                intent.putExtra("username", username.toString())
                startActivity(intent)
                finish()
            }
        }



//        binding.fabInfo.setOnClickListener(
////            val sharedPref = getsSharedPreferences("myPref", MODE_PRIVATE)
////            val lastUser = sharedPref.getString(Constants.LAST_USER, "None")
////            val lastResult =  sharedPref.getInt(Constants.LAST_RESULT, "None")
//
////            val toast = Toast.makeText(this, "hi")
////            toast.show()
//        )
    }
}