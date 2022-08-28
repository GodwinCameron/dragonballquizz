package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityResultsBinding
import com.example.myapplication.models.Constants
import com.example.myapplication.models.Constants.LAST_USER

class ResultsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate((layoutInflater))
        setContentView(binding.root)


        val username = intent.getStringExtra("username").toString()
        val currentScore = intent.getIntExtra("currentScore", 0)
        val quizzType = intent.getStringExtra("quizzType").toString()

        Log.i("!!! Final Score: ", currentScore.toString())


        binding.resultsText.setText("${currentScore}0/50")

        if(currentScore == 0) {
            binding.tvReportMessage.setText("You are a Saibamen")
            binding.ivResultImage.setImageResource(R.drawable.saibamen)
            binding.powerLevel.setText("Power level: Saibamen")
        } else if(currentScore ==1){
            binding.tvReportMessage.setText("You are a Saibamen")
            binding.ivResultImage.setImageResource(R.drawable.saibamen)
            binding.powerLevel.setText("Power level: Saibamen")
        } else if(currentScore ==2){
            binding.tvReportMessage.setText("Getting more powerful!")
            binding.ivResultImage.setImageResource(R.drawable.goku)
            binding.powerLevel.setText("Power level: Base Goku")
        } else if(currentScore ==3){
            binding.tvReportMessage.setText("OVER NINE THOUSAND!!!")
            binding.ivResultImage.setImageResource(R.drawable.nine_thousand)
            binding.powerLevel.setText("Power level: Z Goku")
        } else if(currentScore ==4) {
            binding.tvReportMessage.setText("Even Further Beyond!")
            binding.ivResultImage.setImageResource(R.drawable.gokuresult)
            binding.powerLevel.setText("Power level: Legendary Super Saiyan")
        }  else if(currentScore ==5) {
            binding.tvReportMessage.setText("The power of a God")
            binding.ivResultImage.setImageResource(R.drawable.gokussgsss)
            binding.powerLevel.setText("Power level: Super Saiyan God Super Saiyan")
        }





        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply{
//            putString(Constants.LAST_USER, username)
            putInt(Constants.LAST_RESULT, currentScore)
        }

        binding.btnRetry.setOnClickListener{
            if (quizzType == "QuestionActivity") {
                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, QuestionChoiceActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.btnContinue.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            intent.putExtra("username", username)
            intent.putExtra("currentScore", currentScore)
            startActivity(intent)
            finish()
        }
    }
}