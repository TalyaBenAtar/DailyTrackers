package com.example.dailytrackers

import com.example.commontracker.BaseTrackerActivity

class MainActivity : BaseTrackerActivity() {

    override fun getTrackerTitle() =
        "Workout Tracker"

    override fun getTrackerSubtitle() =
        "Push harder every session"

    override fun getTrackerIconRes() =
        R.drawable.fire

    override fun getStepAmount() =
        10

    override fun getGoalMinutes() =
        60

    override fun getMotivationText() =
        "No excuses. Just progress."

    override fun getPrimaryColorRes() =
        R.color.primary_red

    override fun getBackgroundColorRes() =
        R.color.background_white

    override fun getCardColorRes() =
        R.color.card_white

    override fun getCardStrokeColorRes() =
        R.color.card_orange

    override fun getHighlightColorRes() =
        R.color.primary_red

    override fun getSecondaryCardColorRes() =
        R.color.card_white

    override fun getSecondaryCardStrokeColorRes() =
        R.color.card_orange_second

    override fun getCurrentSessionName(): String {
        return when {
            minutes < 20 ->
                "🔥 Warmup"

            minutes < 50 ->
                "💪 Active Workout"

            else ->
                "👑 Beast Mode"
        }
    }

    override fun getExtraInfoText(
        currentMinutes: Int,
        totalMinutes: Int
    ): String {

        return when {
            currentMinutes == 0 ->
                "Ready to train 🔥"

            currentMinutes < 20 ->
                "Status: Warmup 🔥"

            currentMinutes < 50 ->
                "Status: Active Workout 💪"

            else ->
                "Status: Beast Mode 👑"
        }
    }
}