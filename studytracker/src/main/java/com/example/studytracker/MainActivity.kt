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
}