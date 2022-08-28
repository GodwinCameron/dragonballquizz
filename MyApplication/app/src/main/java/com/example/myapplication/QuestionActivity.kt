package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.myapplication.databinding.ActivityQuestionBinding
import com.example.myapplication.models.Constants.getAllQuestions
import com.example.myapplication.models.Question

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val username = intent.getStringExtra("username").toString()
        var questionNumber = intent.getIntExtra("questionNumber", 0)
        var currentScore = intent.getIntExtra("currentScore", 0)

        title = "Question " + (questionNumber+1).toString()

        //Select current Question
        var questions = getAllQuestions()
        val currentQuestion = questions[questionNumber]

        binding.tvProgress.setText("${questionNumber + 1}/5")
        binding.progressBar.setProgress(questionNumber + 1)
        binding.tvQuestionText.setText(questions[questionNumber].questionText)
        binding.rbAnswerOne.setText(questions[questionNumber].optionOne)
        binding.rbAnswerTwo.setText(questions[questionNumber].optionTwo)

        var optionOne = questions[questionNumber].optionOne
        var optionTwo = questions[questionNumber].optionTwo
        var answer = questions[questionNumber].Answer







        //Call for all my questions


//        updateUI(currentQuestion, username)

        binding.ivIcon.setOnClickListener{
            binding.tvHint.setText(questions[questionNumber].Hint)
        }


        binding.buttonNext.setOnClickListener {
            var selectedAnswer = binding.rbAnswers.checkedRadioButtonId


            if(selectedAnswer == -1) { //means nothing has been selected
                val toast = Toast.makeText(this, "please select your answer", LENGTH_SHORT)
                toast.show()
            }else{
                var userAnswer = findViewById<RadioButton>(selectedAnswer) // -1 nothing selected 0 first one selected, 1 second one selected Find the view that has been selected by their Radio id
                Log.i("!!! Selected Answer: ", userAnswer.text.toString())

                //Check correct answer
                if(userAnswer.text.toString() == answer){
                    currentScore += 1
                    Log.i("!!! Correct? ", "Yes!")
                }

                if(questionNumber+1 == questions.count()){
                    val intent = Intent(this, ResultsActivity::class.java)
                    intent.putExtra("currentScore", currentScore)
                    intent.putExtra("quizzType", "QuestionActivity")
                    startActivity(intent)
                    finish()

                } else {
                    //navigate to next question
                    val intent = Intent(this, QuestionActivity::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("currentScore", currentScore)
                    intent.putExtra("questionNumber", questionNumber + 1)


                    startActivity(intent)
                    finish()
                }
            }

        }

//             TODO:

    }

    //function to update frontend
//    fun updateUI(currentQuestion: Question, username: String){
//        if (currentQuestion.id == 1){
//            binding.tvQuestionText.text = "Welcome ${username}! your first question is ${questions[0].questionText}"
//        } else {
//            binding.tvQuestionText.text = "Welcome ${username}! your next question is ${questions[0].questionText}"
//        }
//        binding.rbAnswerOne.text = currentQuestion.optionOne
//        binding.rbAnswerTwo.text = currentQuestion.optionTwo
//        binding.ivIcon.setImageResource(currentQuestion.icon) //use setImageResource to set images
//
//
//        //progress bar
//        binding.progressBar.progress = currentQuestion.id
//        binding.textViewProgress.text = currentQuestion.id.toString() + "/10"
}