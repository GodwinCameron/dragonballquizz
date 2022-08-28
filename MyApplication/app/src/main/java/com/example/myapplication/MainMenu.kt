package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainMenuBinding
import com.example.myapplication.databinding.ActivityQuestionChoiceBinding

class MainMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username").toString()
        val currentScore = intent.getIntExtra("CurrentScore", 0)

        binding.generalTrivia.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            intent.putExtra("username", username)
        }
        binding.transformations.setOnClickListener{
            val intent = Intent(this, QuestionChoiceActivity::class.java)
            startActivity(intent)
            intent.putExtra("username", username)
        }
        binding.highscores.setOnClickListener{
            val intent = Intent(this, Highscorese::class.java)
            startActivity(intent)
            intent.putExtra("username", username)
            intent.putExtra("currentScore", currentScore)
        }

    }
}


