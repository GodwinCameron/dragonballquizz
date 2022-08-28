package com.example.myapplication.models

import com.example.myapplication.R

object Constants {


    val USER_NAME : String = "username"
    val LAST_USER: String = "lastuser"
    val LAST_RESULT: String = "lastresult"

    fun getAllQuestions() : ArrayList<Question> {
        var allQuestions = ArrayList<Question>()

        val q1 = Question(
            1,
            "Goku is the only surviving, full-blooded Saiyan from planet Vegeta",
            R.drawable.ic_help,
            "True",
            "False",
            "False",
            "Trunks, the half-blooded Saiyan is not the child of Goku..."
        )
        val q2 = Question(
            2,
            "The planet Vegeta was destroyed by Freeza in an effort to prevent the arising of the 'Super Saiyan'",
            R.drawable.ic_help,
            "True",
            "False",
            "True",
            "The only thing that Freeza feared in his conquest was a legend of a foe stronger than himself..."
        )
        val q3 = Question(
            3,
            "To Freeza, he himself was the strongest being in existence",
            R.drawable.ic_help,
            "True",
            "False",
            "False",
            "Freeza, through his father King Cold, knew of characters not yet introduced to the audience until the screening of Dragon Ball Super..."
        )
        val q4 = Question(
            4,
            "Bardock, Goku's father accepted the fate of his planet when a vision of his son, challenging Freeza brought him peace and hope",
            R.drawable.ic_help,
            "True",
            "False",
            "True",
            "Bardock only stopped resisting Freeza's giant death ball upon seeing someone facing him on planet Namek..."
        )
        val q5 = Question(
            5,
            "With the combined energy of the universe, Goku was able to create a signature attack called the Kamehameha",
            R.drawable.ic_help,
            "True",
            "False",
            "False",
            "Goku learnt this technique while training with King Kai on his planet in Other World..."
        )

        allQuestions.add(q1)
        allQuestions.add(q2)
        allQuestions.add(q3)
        allQuestions.add(q4)
        allQuestions.add(q5)




        return allQuestions
    }


    fun getTransformationQuestions() : ArrayList<QuestionChoice> {
        var allQuestions = ArrayList<QuestionChoice>()

        val q1 = QuestionChoice(
            1,
            "The first transformation of the Saiyan race is_?",
            R.drawable.ic_help,
            "Oozaru (Great Ape)",
            "Ikari Rage Form",
            "Super Saiyan",
            "Kaioken",
            "Oozaru (Great Ape)",
            "The Saiyan's legacy is tied to their Monkey like lineage..."
        )
        val q2 = QuestionChoice(
            2,
            "The Super Saiyan transformation could be 'powered up' to higher grades at the expense of the users _ ?",
            R.drawable.ic_help,
            "Stamina",
            "Life Force",
            "Speed",
            "Pain",
            "Speed",
            "Goku showed these forms to Gohan in the Hyperbolic time chamber, to Gohan's surprise Goku said it wasn't enough to beat Cell due to his difficulty to move..."
        )
        val q3 = QuestionChoice(
            3,
            "Before the official release of the Super Saiyan form, Goku transformed during his fight against Lord Slug into a form called?",
            R.drawable.ic_help,
            "Pseudo Super Saiyan",
            "False Super Saiyan",
            "Full Power Saiyan",
            "Golden Saiyan",
            "False Super Saiyan",
            "This name was not disclosed in the film, instead, critics were the first to dub it"
        )
        val q4 = QuestionChoice(
            4,
            "Excluding non-canon content (ie, Dragon Ball GT), how many unique states of Super Saiyan exist?",
            R.drawable.ic_help,
            "3",
            "4-8",
            "8-10",
            "10+",
            "10+",
            "Keep in mind that multiple characters developed the Super Saiyan power into unique forms"
        )
        val q5 = QuestionChoice(
            5,
            "The first person to unluck the Super Saiyan 2 form was_?",
            R.drawable.ic_help,
            "Goku",
            "Vegeta",
            "Gohan",
            "Bardock",
            "Gohan",
            "The winner of the Cells games might know a thing or two..."
        )
        allQuestions.add(q1)
        allQuestions.add(q2)
        allQuestions.add(q3)
        allQuestions.add(q4)
        allQuestions.add(q5)

        return allQuestions

    }
}