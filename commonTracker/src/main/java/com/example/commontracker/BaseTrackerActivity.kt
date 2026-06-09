package com.example.commontracker

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

abstract class BaseTrackerActivity : AppCompatActivity() {

    protected var minutes = 0

    private lateinit var txtMinutes: TextView
    private lateinit var txtGoal: TextView
    private lateinit var progressGoal: ProgressBar

    abstract fun getTrackerTitle(): String
    abstract fun getTrackerSubtitle(): String
    abstract fun getTrackerIcon(): String
    abstract fun getStepAmount(): Int
    abstract fun getGoalMinutes(): Int
    abstract fun getMotivationText(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)

        val txtTitle: TextView = findViewById(R.id.txtTitle)
        val txtSubtitle: TextView = findViewById(R.id.txtSubtitle)
        val txtIcon: TextView = findViewById(R.id.txtIcon)
        val txtMotivation: TextView = findViewById(R.id.txtMotivation)

        txtMinutes = findViewById(R.id.txtMinutes)
        txtGoal = findViewById(R.id.txtGoal)
        progressGoal = findViewById(R.id.progressGoal)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnRemove: Button = findViewById(R.id.btnRemove)
        val btnReset: Button = findViewById(R.id.btnReset)

        val step = getStepAmount()

        txtTitle.text = getTrackerTitle()
        txtSubtitle.text = getTrackerSubtitle()
        txtIcon.text = getTrackerIcon()
        txtMotivation.text = getMotivationText()

        btnAdd.text = "+ $step minutes"
        btnRemove.text = "- $step minutes"

        btnAdd.setOnClickListener {
            minutes += step
            updateMinutesText()
        }

        btnRemove.setOnClickListener {
            minutes -= step
            if (minutes < 0) {
                minutes = 0
            }
            updateMinutesText()
        }

        btnReset.setOnClickListener {
            minutes = 0
            updateMinutesText()
        }

        updateMinutesText()
    }

    private fun updateMinutesText() {
        val goal = getGoalMinutes()
        val progress = if (goal == 0) {
            0
        } else {
            (minutes * 100 / goal).coerceAtMost(100)
        }

        txtMinutes.text = minutes.toMinutesText()
        txtGoal.text = "$minutes / $goal minutes"
        progressGoal.progress = progress
    }
}