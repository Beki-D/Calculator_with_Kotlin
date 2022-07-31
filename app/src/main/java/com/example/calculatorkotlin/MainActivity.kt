package com.example.calculatorkotlin

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    lateinit var workingsTextView:TextView
    lateinit var ResultsTextView:TextView
    lateinit var newWord:String
    lateinit var oldWord:String
    //To be implemented...
    class StackWithList{
        val elements: MutableList<Any> = mutableListOf()

        fun isStackEmpty() = elements.isEmpty()

        fun size() = elements.size

        fun push(item: Any) = elements.add(item)

        fun pop(): Any?{
            val item = elements.lastOrNull()
            if (! (isStackEmpty())){
                elements.removeAt(elements.size - 1)
            }
            return item
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workingsTextView = findViewById(R.id.workingsTextView)
        ResultsTextView = findViewById(R.id.resultsTextView)
    }

    private fun concatText(word:String): StackWithList {
        var textLen = workingsTextView.text.length
        //if(workingsTextView.text.toString()[textLen-1]=="+")
        oldWord = workingsTextView.text.toString()

        var stackObject = StackWithList()
        stackObject.push(word)
        newWord = oldWord + word
        workingsTextView.text = newWord

        return stackObject
    }
    fun clear(view: View) {
        workingsTextView.text=""
    }
    fun equal(view: View) {
        val exp = Expression(workingsTextView.text.toString())
        val result = java.lang.String.format("%.2f", exp.calculate())
        ResultsTextView.text = result
    }
    fun zero(view: View) {
        concatText("0")
    }
    fun one(view: View) {
        concatText("1")
    }
    fun two(view: View) {
        concatText("2")
    }
    fun three(view: View) {
        concatText("3")
    }
    fun six(view: View) {
        concatText("6")
    }
    fun five(view: View) {
        concatText("5")
    }
    fun four(view: View) {
        concatText("4")
    }
    fun multiply(view: View) {
        concatText("*")
    }
    fun nine(view: View) {
        concatText("9")
    }
    fun eight(view: View) {
        concatText("8")
    }
    fun seven(view: View) {
        concatText("7")
    }
    fun divide(view: View) {
        concatText("/")
    }
    fun dot(view: View) {
        concatText(".")
    }
    fun plus(view: View) {
        concatText("+")
    }
    fun minus(view: View) {
        concatText("-")
    }
    fun allClear(view: View) {
        ResultsTextView.text=""
        workingsTextView.text=""
    }
    fun power(view: View) {
        concatText("^")
    }

    fun leftBracket(view: View) {
        concatText("(")
    }
    fun rightBracket(view: View) {
        concatText(")")
    }
}