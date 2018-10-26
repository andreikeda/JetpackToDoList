package br.com.andreikeda.jetpacknotes.list.interactor

import br.com.andreikeda.jetpacknotes.core.NoteViewModel

interface NotesInteractor {
    fun getAllNotes(viewModel: NoteViewModel?)
    fun unregister()
}