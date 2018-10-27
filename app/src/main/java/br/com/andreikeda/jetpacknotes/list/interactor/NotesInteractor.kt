package br.com.andreikeda.jetpacknotes.list.interactor

import br.com.andreikeda.jetpacknotes.core.NoteViewModel
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

interface NotesInteractor {
    fun getAllNotes(viewModel: NoteViewModel?)
    fun unregister()
    fun updateNote(viewModel: NoteViewModel?, note: NoteEntity)
}