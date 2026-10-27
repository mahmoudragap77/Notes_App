package com.maadcoding.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.maadcoding.notesapp.ui.screens.AddNoteScreen
import com.maadcoding.notesapp.ui.screens.EditNoteScreen
import com.maadcoding.notesapp.ui.HomeScreen

@Composable
fun NotesNavApp(
    modifier: Modifier = Modifier,
    initialKey: NavKey = HomeKey
) {
    val backStack = rememberNavBackStack(initialKey)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        modifier = modifier,
        entryProvider = { key ->
            when (key) {
                is HomeKey -> NavEntry(key) {
                    HomeScreen(
                        onAddNoteClick = { backStack.add(AddNoteKey) },
                        onNoteClick = { note -> backStack.add(EditNoteKey(note)) }
                    )
                }
                is AddNoteKey -> NavEntry(key) {
                    AddNoteScreen(
                        onNavigateBack = { backStack.removeLastOrNull() }
                    )
                }
                is EditNoteKey -> NavEntry(key) {
                    EditNoteScreen(
                        note = key.note,
                        onNavigateBack = { backStack.removeLastOrNull() }
                    )
                }
                else -> error("Unknown navigation key: $key")
            }
        }
    )
}
