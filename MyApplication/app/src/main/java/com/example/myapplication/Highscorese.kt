package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityHighscoreseBinding
import com.example.myapplication.databinding.ActivityMainMenuBinding

class Highscorese : AppCompatActivity() {

    private lateinit var binding: ActivityHighscoreseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHighscoreseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val username = intent.getStringExtra("username").toString()
        val currentScore = intent.getIntExtra("CurrentScore", 0)


        binding.tvGeneralScore.setText("Cameron got 5/5")
        binding.tvTransformationsScore.setText("${username} got ${currentScore}/5")


        binding.btnReset.setOnClickListener{
            binding.tvGeneralScore.setText("0/5")
            binding.tvTransformationsScore.setText("0/5")
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}