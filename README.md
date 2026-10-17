# 📝 Notes App

An Android notes application built with **Kotlin** and **Jetpack Compose**. Create, view, edit, and delete notes, all stored locally on the device using **Room**.

## ✨ Features

- Create and save notes
- View all notes in a scrollable list
- Edit and delete existing notes
- Offline-first: notes are stored locally with Room Database
- Reactive UI: the list updates automatically whenever the data changes (Kotlin Flow)
- Material 3 design with light and dark color schemes

## 🛠️ Tech Stack

| Category | Technology |
| --- | --- |
| Language | Kotlin |
| UI | Jetpack Compose, Material 3 |
| Local database | Room `2.8.5` (with KSP) |
| Architecture | MVVM (`AndroidViewModel`) |
| Async | Kotlin Coroutines & Flow |
| Testing | JUnit, AndroidX Test, Compose UI Test |

## 📱 Requirements

- Android Studio (latest stable version recommended)
- JDK 11 or higher
- Min SDK: 24 (Android 7.0)
- Target / Compile SDK: 36

## 🗂️ Project Structure

```
app/src/main/java/com/maadcoding/notesapp/
├── database/
│   ├── Note.kt            # Room entity (id, content)
│   ├── NoteDao.kt         # Data access: upsert, delete, getAllNotes (Flow)
│   └── RoomDBHelper.kt    # Room database (singleton)
└── ui/
    ├── NoteViewModel.kt   # Exposes notes and handles upsert / delete
    ├── activity/
    │   ├── MainActivity.kt      # Notes list screen
    │   ├── AddNoteActivity.kt   # Add a new note
    │   └── EditNoteActivity.kt  # Edit an existing note
    ├── icon/              # Custom icons
    └── theme/             # Colors, typography, and theme
```

## 🧱 Architecture

The app follows a simple MVVM structure:

1. **Room** (`Note`, `NoteDao`, `RoomDBHelper`) stores the notes in a local `note` table.
2. **`NoteViewModel`** reads notes as a `Flow` and runs write operations inside `viewModelScope`.
3. **Compose screens** collect the Flow as state, so the UI stays in sync with the database.

## 🧪 Running Tests

Instrumented tests include a Room database test (`RoomDataBaseTest`).

## 🔮 Ideas for Future Improvements

- Note titles and timestamps
- Search and sorting
- Note categories or colors
- Navigation Compose instead of multiple activities
- Dependency injection (Hilt)
