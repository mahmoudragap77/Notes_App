package com.maadcoding.notesapp.roomtest

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.maadcoding.notesapp.database.Note
import com.maadcoding.notesapp.database.NoteDao
import com.maadcoding.notesapp.database.RoomDBHelper
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomDataBaseTest {
    private lateinit var db: RoomDBHelper
    private lateinit var dao : NoteDao

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db= Room.inMemoryDatabaseBuilder(context, RoomDBHelper::class.java)
            .setDriver(AndroidSQLiteDriver())
            .build()
        dao = db.dao
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun insertTest(){
        val note = Note(1, "test")
        runTest {
            dao.insert(note)
            val notes = dao.getAllNotes().first()
           assertEquals(1, notes.size)
           assertEquals(note, notes[0])
        }
    }


    @Test
    fun selectTest_EmptyNote(){

        runTest {
            val notes = dao.getAllNotes().first()
            TestCase.assertTrue(notes.isEmpty())
        }
    }

    @Test
    fun selectTest_WithNotes(){
        runTest {
            val firstNote = Note(1, "One")
            val secondNote = Note(2, "Two")
            val thirdNote = Note(3, "Three")

            dao.insert(firstNote)
            dao.insert(secondNote)
            dao.insert(thirdNote)
            val notes = dao.getAllNotes().first()

            assertEquals(3, notes.size)
           assertEquals(listOf(firstNote, secondNote, thirdNote), notes)
        }
    }
    }