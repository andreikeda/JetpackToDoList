package br.com.andreikeda.jetpacknotes.create.interactor

import android.app.Application
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

interface CreateNoteInteractor {
    fun createNote(application: Application, note: NoteEntity)
    fun unregister()
}