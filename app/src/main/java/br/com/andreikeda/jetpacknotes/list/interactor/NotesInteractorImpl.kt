package br.com.andreikeda.jetpacknotes.list.interactor

import br.com.andreikeda.jetpacknotes.core.NoteViewModel
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

class NotesInteractorImpl(var output: NotesInteractorOutput?) : NotesInteractor {
    override fun getAllNotes(viewModel: NoteViewModel?) {
        val result = viewModel?.getNotes()
        result?.let { output?.onNotesReceived(result) } ?: run { output?.onNotesError("error getting notes") }
    }

    override fun unregister() {
        output = null
    }

    override fun updateNote(viewModel: NoteViewModel?, note: NoteEntity) {
        viewModel?.updateNote(note)
    }
}