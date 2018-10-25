package br.com.andreikeda.jetpacknotes.list.interactor

import androidx.lifecycle.LiveData
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

interface NotesInteractorOutput {
    fun onNotesReceived(notes: LiveData<List<NoteEntity>>)
    fun onNotesError(errorMessage: String)
}