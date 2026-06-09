package com.example.studytracker

import com.example.commontracker.BaseTrackerActivity

class MainActivity : BaseTrackerActivity() {

    override fun getTrackerTitle(): String {
        return "Study Tracker"
    }

    override fun getTrackerSubtitle(): String {
        return "Track your study sessions"
    }

    override fun getTrackerIcon(): String {
        return "📚"
    }

    override fun getStepAmount(): Int {
        return 25
    }

    override fun getGoalMinutes(): Int {
        return 120
    }

    override fun getMotivationText(): String {
        return "Small steps, big brain."
    }
}