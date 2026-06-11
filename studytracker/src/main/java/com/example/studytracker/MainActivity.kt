package com.example.studytracker

import com.example.commontracker.BaseTrackerActivity

class MainActivity : BaseTrackerActivity() {

    private var isStudySession = true

    override fun getTrackerTitle() = "Study Tracker"

    override fun getTrackerSubtitle() =
        "Plan focus sessions and mindful breaks"

    override fun getTrackerIconRes() = R.drawable.stack_of_books

    override fun getStepAmount() = 25

    override fun getGoalMinutes() = 120

    override fun getMotivationText() =
        "Focus now, future you says thanks."


override fun getPrimaryColorRes() =
    R.color.primary_purple

    override fun getBackgroundColorRes() =
        R.color.background_purple

    override fun getCardColorRes() =
        R.color.card_purple

    override fun getCardStrokeColorRes() =
        R.color.card_purple_border

    override fun getHighlightColorRes() =
        R.color.highlight_purple

    override fun getSecondaryCardColorRes() =
        R.color.card_purple

    override fun getSecondaryCardStrokeColorRes() =
        R.color.card_purple_border

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