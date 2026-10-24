package com.maadcoding.notesapp.navigation

import androidx.navigation3.runtime.NavKey
import com.maadcoding.notesapp.database.Note
import kotlinx.serialization.Serializable

@Serializable
data object HomeKey : NavKey

@Serializable
data object AddNoteKey : NavKey

@Serializable
data class EditNoteKey(val note: Note) : NavKey
