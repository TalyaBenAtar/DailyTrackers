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

> Add screenshots here

```markdown
![Study Tracker Screenshot](images/study_tracker.png)
```

---

## 🎥 Demo Video

> Add study tracker demo video here

```markdown
[Study Tracker Demo](videos/study_tracker_demo.mp4)
```

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

> Add screenshots here

```markdown
![Workout Tracker Screenshot](images/workout_tracker.png)
```

---

## 🎥 Demo Video

> Add workout tracker demo video here

```markdown
[Workout Tracker Demo](videos/workout_tracker_demo.mp4)
```

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
