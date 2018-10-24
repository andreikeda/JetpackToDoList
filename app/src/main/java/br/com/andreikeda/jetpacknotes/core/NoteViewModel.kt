package br.com.andreikeda.jetpacknotes.core

import androidx.lifecycle.LiveData
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

interface NoteViewModel {
    fun createNote(note: NoteEntity)
    fun deleteNote(note: NoteEntity)
    fun deleteAllNotes()
    fun getNotes() : LiveData<List<NoteEntity>>?
    fun updateNote(note: NoteEntity)
}