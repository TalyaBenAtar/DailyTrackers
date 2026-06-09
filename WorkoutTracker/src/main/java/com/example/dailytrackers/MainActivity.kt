package com.example.dailytrackers

import com.example.commontracker.BaseTrackerActivity

class MainActivity : BaseTrackerActivity() {

    override fun getTrackerTitle(): String {
        return "Workout Tracker"
    }

    override fun getTrackerSubtitle(): String {
        return "Track your workout time"
    }

    override fun getTrackerIcon(): String {
        return "💪"
    }

    override fun getStepAmount(): Int {
        return 10
    }
}