# 📱 DailyTrackers

DailyTrackers is a multi-module Android project developed in **Kotlin**.

The project demonstrates how multiple Android applications can share functionality through a common module while maintaining unique behavior, appearance, and business logic.

---

# 🏗️ Project Structure

```text
DailyTrackers
│
├── commonTracker
│   └── BaseTrackerActivity
│
├── studyTracker
│   └── MainActivity : BaseTrackerActivity
│
└── workoutTracker
    └── MainActivity : BaseTrackerActivity
```

The project contains:

- 📚 **StudyTracker**
- 🔥 **WorkoutTracker**
- 🧩 **CommonTracker**

---

# 🧩 CommonTracker

The **CommonTracker** module contains all shared functionality used by both applications.

## Features

- Abstract `BaseTrackerActivity`
- Shared user interface
- Goal tracking system
- Session management
- Progress tracking
- Session history
- Shared utility extensions
- Theme customization support

The goal of this module is to eliminate duplicated code and provide a common foundation for both applications.

---

# 📚 StudyTracker

StudyTracker helps users organize study sessions and breaks throughout the day.

## Features

- 📚 Study Mode
- ☕ Break Mode
- Daily Study Goal
- Progress Tracking
- Session History
- Focus Block Counter
- Custom Purple Theme

## Unique Behavior

Study sessions contribute toward the daily goal.

Break sessions are recorded in the session history but **do not count toward the study goal**, allowing users to accurately measure productive study time.

### Example Session History

```text
📚 Study: 50 minutes
☕ Break: 25 minutes
📚 Study: 75 minutes
```

---

## 📸 Screenshots

<table>
  <tr>
    <td align="center">
      <img width="351" height="791" alt="Study_Tracker" src="https://github.com/user-attachments/assets/10fd669c-db87-4567-b5e7-bae24dcbdd09" />
      No Data
    </td>
    <td align="center">
      <img width="311" height="691" alt="Study_Tracker" src="https://github.com/user-attachments/assets/ed65656f-1b36-49a1-b0f2-29d728b1338a" />
      Data Put In
    </td>
    <td align="center">
        <img width="311" height="691" alt="Study_Tracker" src="https://github.com/user-attachments/assets/ee41864b-0f4e-4a86-8e80-333ec6665810" />
      Session Saved
    </td>
  </tr>
</table>


---

## 🎥 Demo Video

https://github.com/user-attachments/assets/ae5db02e-1d0c-47bd-b529-a749636e7eaa


---

# 🔥 WorkoutTracker

WorkoutTracker helps users monitor workout progress and training sessions.

## Features

- Daily Workout Goal
- Session History
- Progress Tracking
- Dynamic Workout Status
- Custom Fire Theme
- Goal Achievement Tracking

## Workout Levels

| Duration | Status |
|----------|---------|
| 0 - 19 min | 🔥 Warmup |
| 20 - 49 min | 💪 Active Workout |
| 50+ min | 👑 Beast Mode |

## Example Session History

```text
🔥 Warmup: 10 minutes
💪 Active Workout: 30 minutes
👑 Beast Mode: 60 minutes
```

---

## 📸 Screenshots

<table>
  <tr>
    <td align="center">
      <img width="311" height="691" alt="Screenshot_20260611_142112_Workout_Tracker" src="https://github.com/user-attachments/assets/e1726ab1-05ae-412a-abc0-2c0e3008c30c" />
      No Data
    </td>
    <td align="center">
      <img width="311" height="691" alt="Screenshot_20260611_142127_Workout_Tracker" src="https://github.com/user-attachments/assets/c17ae81f-c582-455c-8aeb-960c9ab760ba" />
      Data Put In
    </td>
    <td align="center">
        <img width="311" height="691" alt="Screenshot_20260611_142134_Workout_Tracker" src="https://github.com/user-attachments/assets/25b5deaf-bc43-4fc5-ae73-3429d3e9637d" />
      Session Saved
    </td>
  </tr>
</table>

---

## 🎥 Demo Video

https://github.com/user-attachments/assets/281320e3-cca6-4c8b-addc-0758bb1a8f21


---

# 🎨 Themes

Both applications use the same shared infrastructure while providing their own visual identity.

## 📚 StudyTracker Theme

- Soft Purple Colors
- Productivity-Oriented Design
- Study & Break Workflow

## 🔥 WorkoutTracker Theme

- Red & Orange Fire Theme
- High-Energy Design
- Dynamic Workout Status System

---

# 🛠️ Technologies Used

- Kotlin
- Android Studio
- Android SDK
- AppCompat
- Material Components
- Multi-Module Architecture
- Object-Oriented Programming
- Inheritance
- Abstraction

---

# 🎯 Assignment Goal

This project was developed as part of an Android Development course assignment.

The assignment required the creation of two Android applications sharing a common module that contains an abstract activity, while extending the project beyond the classroom example with additional functionality and customization.

---

# 👩‍💻 Author

**Talya Ben Atar**

B.Sc. Computer Science Student

Afeka College of Engineering
