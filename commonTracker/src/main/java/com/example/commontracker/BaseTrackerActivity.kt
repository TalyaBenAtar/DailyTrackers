package com.example.commontracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

abstract class BaseTrackerActivity : AppCompatActivity() {

    protected var minutes = 0

    abstract fun getTrackerTitle(): String
    abstract fun getTrackerSubtitle(): String
    abstract fun getTrackerIcon(): String
    abstract fun getStepAmount(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)

        val txtTitle: TextView = findViewById(R.id.txtTitle)
        val txtSubtitle: TextView = findViewById(R.id.txtSubtitle)
        val txtIcon: TextView = findViewById(R.id.txtIcon)
        val txtMinutes: TextView = findViewById(R.id.txtMinutes)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnRemove: Button = findViewById(R.id.btnRemove)
        val btnReset: Button = findViewById(R.id.btnReset)

        val step = getStepAmount()

        txtTitle.text = getTrackerTitle()
        txtSubtitle.text = getTrackerSubtitle()
        txtIcon.text = getTrackerIcon()

        btnAdd.text = "+ $step minutes"
        btnRemove.text = "- $step minutes"

        fun updateMinutesText() {
            txtMinutes.text = minutes.toMinutesText()
        }

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
}