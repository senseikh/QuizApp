package com.kisera.quizapp_12

object Constants {
    fun getQuestions ():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 =Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionList.add(que1)
        //2
        val que2 =Question(2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Australia",
            "kuwait",
            "india",
            "Austria",
            1
        )
        questionList.add(que2)
        val que3 =Question(3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "new zealand",
            "Belgium",
            "Austria",
            3
        )
        questionList.add(que3)
        val que4 =Question(4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "brazil",
            "Armenia",
            "Austria",
            2
        )
        questionList.add(que4)
        val que5 =Question(5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "germany",
            "Australia",
            "denmark",
            "Austria",
            3
        )
        questionList.add(que5)
        val que6 =Question(6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "brazil",
            "Armenia",
            "fiji",
            4
        )
        questionList.add(que6)
        val que7 =Question(7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "india",
            "Australia",
            "germany",
            "Austria",
            3
        )
        questionList.add(que7)
        val que8 =Question(8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Argentina",
            "Australia",
            "Armenia",
            "India",
            4
        )
        questionList.add(que8)
        val que9 =Question(9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "kuwait",
            "Australia",
            "belgium",
            "Austria",
            1
        )
        questionList.add(que9)
        val que10 =Question(10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "kenya",
            "Austria",
            2
        )
        questionList.add(que10)
        return questionList
    }
}