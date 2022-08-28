package com.example.myapplication.models
// data keyword is used for blueprinting
//data class needs () instead of {}
data class QuestionChoice (
    val id: Int,
    val questionText: String,
    val icon: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val Answer: String,
    val Hint: String
//    val active: Boolean
    // val answerL Int
)