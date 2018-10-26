package br.com.andreikeda.jetpacknotes.create.interactor

import br.com.andreikeda.jetpacknotes.core.NoteViewModel
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

interface CreateNoteInteractor {
    fun createNote(viewModel: NoteViewModel?, note: NoteEntity)
    fun unregister()
}