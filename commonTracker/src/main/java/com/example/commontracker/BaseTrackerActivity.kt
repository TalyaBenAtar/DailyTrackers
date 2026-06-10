package com.example.commontracker

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

abstract class BaseTrackerActivity : AppCompatActivity() {


    protected var minutes = 0

    private var savedTotalMinutes = 0
    private var dailyGoalMinutes = 0
    private val savedSessions = mutableListOf<String>()

    private lateinit var main: View
    private lateinit var cardContainer: View

    private lateinit var txtMinutes: TextView
    private lateinit var txtGoal: TextView
    private lateinit var txtMotivation: TextView
    private lateinit var txtExtraInfo: TextView
    private lateinit var txtSessions: TextView

    private lateinit var edtGoal: EditText
    private lateinit var progressGoal: ProgressBar
    private lateinit var btnSessionType: Button

    abstract fun getTrackerTitle(): String
    abstract fun getTrackerSubtitle(): String
    abstract fun getTrackerIcon(): String
    abstract fun getStepAmount(): Int
    abstract fun getGoalMinutes(): Int
    abstract fun getMotivationText(): String

    abstract fun getPrimaryColor(): Int
    abstract fun getBackgroundColor(): Int

    abstract fun getCardColor(): Int
    abstract fun getCardStrokeColor(): Int

    abstract fun getHighlightColor(): Int
    abstract fun getSecondaryCardColor(): Int
    abstract fun getSecondaryCardStrokeColor(): Int

    abstract fun getCurrentSessionName(): String
    abstract fun getExtraInfoText(currentMinutes: Int, totalMinutes: Int): String

    open fun hasSessionTypeButton(): Boolean = false
    open fun getSessionTypeButtonText(): String = ""
    open fun onSessionTypeButtonClicked() {}
    open fun shouldCountSessionTowardsGoal(): Boolean = true
    open fun shouldCurrentSessionCountTowardsGoal(): Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)

        dailyGoalMinutes = getGoalMinutes()

        main = findViewById(R.id.main)
        cardContainer = findViewById(R.id.cardContainer)

        val txtTitle: TextView = findViewById(R.id.txtTitle)
        val txtSubtitle: TextView = findViewById(R.id.txtSubtitle)
        val txtIcon: TextView = findViewById(R.id.txtIcon)

        txtMinutes = findViewById(R.id.txtMinutes)
        txtGoal = findViewById(R.id.txtGoal)
        txtMotivation = findViewById(R.id.txtMotivation)
        txtExtraInfo = findViewById(R.id.txtExtraInfo)
        txtSessions = findViewById(R.id.txtSessions)

        edtGoal = findViewById(R.id.edtGoal)
        progressGoal = findViewById(R.id.progressGoal)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnRemove: Button = findViewById(R.id.btnRemove)
        val btnReset: Button = findViewById(R.id.btnReset)
        val btnSaveSession: Button = findViewById(R.id.btnSaveSession)
        val btnSetGoal: Button = findViewById(R.id.btnSetGoal)

        btnSessionType = findViewById(R.id.btnSessionType)

        val step = getStepAmount()

        txtTitle.text = getTrackerTitle()
        txtSubtitle.text = getTrackerSubtitle()
        txtIcon.text = getTrackerIcon()
        txtMotivation.text = getMotivationText()

        edtGoal.setText(dailyGoalMinutes.toString())

        btnAdd.text = "+ $step"
        btnRemove.text = "- $step"

        applyColors(
            btnAdd,
            btnRemove,
            btnReset,
            btnSaveSession,
            btnSetGoal,
            btnSessionType
        )

        btnAdd.setOnClickListener {
            minutes += step
            updateUI()
        }

        btnRemove.setOnClickListener {
            minutes -= step
            if (minutes < 0) {
                minutes = 0
            }
            updateUI()
        }

        btnReset.setOnClickListener {
            minutes = 0
            updateUI()
        }

        btnSetGoal.setOnClickListener {
            val newGoal = edtGoal.text.toString().toIntOrNull()

            if (newGoal != null && newGoal > 0) {
                dailyGoalMinutes = newGoal
                updateUI()
            }
        }

        btnSaveSession.setOnClickListener {
            saveCurrentSession()
        }

        if (hasSessionTypeButton()) {
            btnSessionType.visibility = View.VISIBLE
            btnSessionType.text = getSessionTypeButtonText()

            btnSessionType.setOnClickListener {
                onSessionTypeButtonClicked()
                btnSessionType.text = getSessionTypeButtonText()
                updateUI()
            }
        } else {
            btnSessionType.visibility = View.GONE
        }

        updateUI()
    }

    private fun saveCurrentSession() {
        if (minutes == 0) return

        savedSessions.add(
            "${getCurrentSessionName()}: ${minutes.toMinutesText()}"
        )

//        savedTotalMinutes += minutes
        if (shouldCountSessionTowardsGoal()) {
            savedTotalMinutes += minutes
        }
        minutes = 0

        updateUI()
    }

    private fun updateUI() {

        val currentMinutesForGoal =
            if (shouldCurrentSessionCountTowardsGoal()) {
                minutes
            } else {
                0
            }

        val totalWithCurrent =
            savedTotalMinutes + currentMinutesForGoal

        val progress =
            (totalWithCurrent * 100 / dailyGoalMinutes)
                .coerceAtMost(100)

        txtMinutes.text = minutes.toMinutesText()
        progressGoal.progress = progress

        txtGoal.text =
            if (totalWithCurrent < dailyGoalMinutes) {
                "$totalWithCurrent / $dailyGoalMinutes minutes"
            } else {
                "Goal completed 🎉 ($totalWithCurrent minutes)"
            }

        txtExtraInfo.text =
            getExtraInfoText(minutes, totalWithCurrent)

        txtSessions.text =
            if (savedSessions.isEmpty()) {
                "No sessions saved yet"
            } else {
                savedSessions.joinToString("\n")
            }
    }

    private fun applyColors(vararg buttons: Button) {

        val primaryColor = getPrimaryColor()

        main.setBackgroundColor(getBackgroundColor())

        progressGoal.progressTintList =
            ColorStateList.valueOf(primaryColor)

        txtMinutes.setTextColor(getHighlightColor())

        buttons.forEach {
            it.backgroundTintList =
                ColorStateList.valueOf(primaryColor)

            it.setTextColor(Color.WHITE)
        }

        val cardBackground = GradientDrawable()
        cardBackground.setColor(getCardColor())
        cardBackground.cornerRadius =
            28f * resources.displayMetrics.density
        cardBackground.setStroke(
            2,
            getCardStrokeColor()
        )

        cardContainer.background = cardBackground

        val sessionBackground = GradientDrawable()
        sessionBackground.setColor(
            getSecondaryCardColor()
        )
        sessionBackground.cornerRadius =
            22f * resources.displayMetrics.density
        sessionBackground.setStroke(
            2,
            getSecondaryCardStrokeColor()
        )

        txtSessions.background = sessionBackground
    }


}
