package com.example.dailytrackers

import android.graphics.Color
import com.example.commontracker.BaseTrackerActivity

class MainActivity : BaseTrackerActivity() {

    override fun getTrackerTitle() =
        "Workout Tracker"

    override fun getTrackerSubtitle() =
        "Push harder every session"

//    override fun getTrackerIcon() =
//        "🔥"
    override fun getTrackerIconRes() =
        R.drawable.fire

    override fun getStepAmount() =
        10

    override fun getGoalMinutes() =
        60

    override fun getMotivationText() =
        "No excuses. Just progress."

    override fun getPrimaryColor() =
        Color.parseColor("#E63946")

    override fun getBackgroundColor() =
        Color.parseColor("#FFF6F0")

    override fun getCardColor() =
        Color.parseColor("#FFF0E6")

    override fun getCardStrokeColor() =
        Color.parseColor("#FF7A45")

    override fun getHighlightColor() =
        Color.parseColor("#E63946")

    override fun getSecondaryCardColor() =
        Color.parseColor("#FFF0E6")

    override fun getSecondaryCardStrokeColor() =
        Color.parseColor("#FFB088")

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