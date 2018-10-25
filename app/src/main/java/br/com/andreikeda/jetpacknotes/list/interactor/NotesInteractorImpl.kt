package br.com.andreikeda.jetpacknotes.list.interactor

import android.app.Application
import br.com.andreikeda.jetpacknotes.core.repository.NoteRepositoryImpl
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NotesInteractorImpl(var output: NotesInteractorOutput?) : NotesInteractor {
    override fun getAllNotes(application: Application) {
        doAsync {
            val result = NoteRepositoryImpl(application).getNotes()

            uiThread {
                result?.let { output?.onNotesReceived(it) } ?: run { output?.onNotesError("error getting notes") }
            }
        }
    }

    override fun unregister() {
        output = null
    }
}