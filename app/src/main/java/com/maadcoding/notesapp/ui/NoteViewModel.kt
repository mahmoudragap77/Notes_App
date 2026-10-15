package com.maadcoding.notesapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.database.RoomDBHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel(context : Application)   : AndroidViewModel(context) {

   private val db = RoomDBHelper.getInstance(context)
    val dao = db.dao

    val notes = dao.getAllNotes()
    fun upsert(note: Note){
        viewModelScope.launch {
            dao.insert(note)
        }
    }

    fun delete(note: Note){
        viewModelScope.launch {
            dao.delete(note)
        }
    }



}

