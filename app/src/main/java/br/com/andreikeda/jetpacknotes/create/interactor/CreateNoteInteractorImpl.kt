package br.com.andreikeda.jetpacknotes.create.interactor

import android.app.Application
import br.com.andreikeda.jetpacknotes.core.repository.NoteRepositoryImpl
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CreateNoteInteractorImpl(var output: CreateNoteInteractorOutput?) : CreateNoteInteractor {
    override fun createNote(application: Application, note: NoteEntity) {
        doAsync {
            NoteRepositoryImpl(application).createNote(note)

            uiThread {
                output?.onCreateSuccess()
            }
        }
    }

    override fun unregister() {
        output = null
    }
}