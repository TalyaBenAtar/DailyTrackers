package com.example.studytracker

import android.graphics.Color
import com.example.commontracker.BaseTrackerActivity

class MainActivity : BaseTrackerActivity() {

    private var isStudySession = true

    override fun getTrackerTitle() = "Study Tracker"

    override fun getTrackerSubtitle() =
        "Plan focus sessions and mindful breaks"

    override fun getTrackerIcon() = "📚"

    override fun getStepAmount() = 25

    override fun getGoalMinutes() = 120

    override fun getMotivationText() =
        "Focus now, future you says thanks."

    override fun getPrimaryColor() =
        Color.parseColor("#8B5CF6")

    override fun getBackgroundColor() =
        Color.parseColor("#F8F5FF")

    override fun getCardColor() =
        Color.parseColor("#EEE7FF")

    override fun getCardStrokeColor() =
        Color.parseColor("#D6C7FF")

    override fun getHighlightColor() =
        Color.parseColor("#6D28D9")

    override fun getSecondaryCardColor() =
        Color.parseColor("#EEE7FF")

    override fun getSecondaryCardStrokeColor() =
        Color.parseColor("#D6C7FF")

    override fun getCurrentSessionName(): String {
        return if (isStudySession) {
            "📚 Study"
        } else {
            "☕ Break"
        }
    }

    override fun hasSessionTypeButton() = true

    override fun getSessionTypeButtonText(): String {
        return if (isStudySession) {
            "Mode: Study 📚"
        } else {
            "Mode: Break ☕"
        }
    }

    override fun onSessionTypeButtonClicked() {
        isStudySession = !isStudySession
    }

    override fun getExtraInfoText(
        currentMinutes: Int,
        totalMinutes: Int
    ): String {

        val focusBlocks = totalMinutes / 25

        return "Focus blocks completed: $focusBlocks"
    }

    override fun shouldCountSessionTowardsGoal(): Boolean {
        return isStudySession
    }

    override fun shouldCurrentSessionCountTowardsGoal(): Boolean {
        return isStudySession
    }
}