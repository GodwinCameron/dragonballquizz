package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.myapplication.databinding.ActivityQuestionBinding
import com.example.myapplication.databinding.ActivityQuestionChoiceBinding
import com.example.myapplication.models.Constants.getAllQuestions
import com.example.myapplication.models.Constants.getTransformationQuestions
import com.example.myapplication.models.Question

class QuestionChoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionChoiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionChoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val username = intent.getStringExtra("username").toString()
        var questionNumber = intent.getIntExtra("questionNumber", 0)
        var currentScore = intent.getIntExtra("currentScore", 0)

        title = "Question " + (questionNumber + 1).toString()

        //Select current Question
        var questions = getTransformationQuestions()
        val currentQuestion = questions[questionNumber]

        binding.tvProgress.setText("${questionNumber + 1}/5")
        binding.progressBar.setProgress(questionNumber + 1)
        binding.tvQuestionText.setText(questions[questionNumber].questionText)
        binding.rbAnswerOne.setText(questions[questionNumber].optionOne)
        binding.rbAnswerTwo.setText(questions[questionNumber].optionTwo)
        binding.rbAnswerThree.setText(questions[questionNumber].optionThree)
        binding.rbAnswerFour.setText(questions[questionNumber].optionFour)

        var optionOne = questions[questionNumber].optionOne
        var optionTwo = questions[questionNumber].optionTwo
        var answer = questions[questionNumber].Answer




        binding.ivIcon.setOnClickListener {
            binding.tvHint.setText(questions[questionNumber].Hint)
        }


        binding.buttonNext.setOnClickListener {
            var selectedAnswer = binding.rbAnswers.checkedRadioButtonId


            if (selectedAnswer == -1) { //means nothing has been selected
                val toast = Toast.makeText(this, "please select your answer", LENGTH_SHORT)
                toast.show()
            } else {
                var userAnswer =
                    findViewById<RadioButton>(selectedAnswer) // -1 nothing selected 0 first one selected, 1 second one selected Find the view that has been selected by their Radio id
                Log.i("!!! Selected Answer: ", userAnswer.text.toString())

                //Check correct answer
                if (userAnswer.text.toString() == answer) {
                    currentScore += 1
                    Log.i("!!! Correct? ", "Yes!")
                }

                if (questionNumber + 1 == questions.count()) {
                    val intent = Intent(this, ResultsActivity::class.java)
                    intent.putExtra("currentScore", currentScore)
                    startActivity(intent)
                    finish()

                } else {
                    //navigate to next question
                    val intent = Intent(this, QuestionChoiceActivity::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("currentScore", currentScore)
                    intent.putExtra("questionNumber", questionNumber + 1)


                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}
