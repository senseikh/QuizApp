package com.kisera.quizapp_12

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int =1
    private var mQuestionsList:ArrayList<Question>? =null
    private var mSelectedOptionPosition: Int =0

    private var progressBar : ProgressBar? =null
    private var tvTextView : TextView? = null
    private var tvQuestions: TextView? = null
    private var ivImage : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var submitButton :Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        tvTextView = findViewById(R.id.tv_progressBar)
        tvQuestions = findViewById(R.id.tv_Question)
        ivImage = findViewById(R.id.tv_image)

        tvOptionOne =findViewById(R.id.option_one)
        tvOptionTwo =findViewById(R.id.option_two)
        tvOptionThree =findViewById(R.id.option_three)
        tvOptionFour  = findViewById(R.id.option_four)
        submitButton = findViewById(R.id.submitButton)

        tvOptionOne?.setOnClickListener (this)
        tvOptionTwo?.setOnClickListener (this)
        tvOptionThree?.setOnClickListener (this)
        tvOptionFour?.setOnClickListener (this)
        submitButton?.setOnClickListener (this)

        mQuestionsList  = Constants.getQuestions()


        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question? = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question!!.image)
        progressBar?.progress = mCurrentPosition
        tv_progressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestions?.text = question?.question
        tvOptionOne?.text = question?.optionOne
        tvOptionTwo?.text = question?.optionTwo
        tvOptionThree?.text = question?.optionThree
        tvOptionFour?.text = question?.optionFour

        //setting the Button submit to finish after finishing answering the question

        if (mCurrentPosition!! == mQuestionsList!!.size){
            submitButton?.text ="Finish"
        }else{
            submitButton?.text ="Submit"
        }
    }
    //creating a default option view in order to get the actual first view of the textView fields
    //so that you can choose from either the option provided

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        //iterate through the options in order to change the color of the option selsected
        for (option in options){
            //set the color
            option.setTextColor(Color.parseColor("#B7F0AD"))
            //after above set it back by calling the below method
            option.typeface = Typeface.DEFAULT
            //set your own background using the created drawable file
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_options_border_backgroundimage
            )
        }

    }

    //method that allows us to display the selected textview border field
    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#586BA4"))
        tv.setTypeface (tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one ->{
                tvOptionOne?.let {
                    selectedOptionView(it, selectedOptionNum = 1)
                }
            }
            R.id.option_two ->{
                tvOptionTwo?.let {
                    selectedOptionView(it, selectedOptionNum = 2)
                }
            }
            R.id.option_three ->{
                tvOptionThree?.let {
                    selectedOptionView(it, selectedOptionNum = 3)
                }
            }
            R.id.option_four ->{
                tvOptionFour?.let {
                    selectedOptionView(it, selectedOptionNum = 4)
                }
            }
            R.id.submitButton ->{
                if (mSelectedOptionPosition ==0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <=mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                        Toast.makeText(this, "Congratulations", Toast.LENGTH_LONG).show()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_border_background)
                    }
                    answerView(question.correctAnswer,R.drawable.correct_border_background)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        submitButton!!.text ="Finish"
                    }else{
                        submitButton!!.text ="Go to the next Question"
                    }
                    mSelectedOptionPosition =0
                }
            }
        }
    }
    //function for making the selected question to either display different color

    private fun answerView (answer: Int, drawableView:Int){
        when(answer){
            1 ->{
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                   drawableView
                )
            }
            2 ->{
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3 ->{
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4 ->{
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }
}