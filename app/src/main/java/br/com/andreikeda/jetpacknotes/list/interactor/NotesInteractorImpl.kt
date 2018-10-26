package br.com.andreikeda.jetpacknotes.list.interactor

import android.util.Log
import br.com.andreikeda.jetpacknotes.core.NoteViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NotesInteractorImpl(var output: NotesInteractorOutput?) : NotesInteractor {
    override fun getAllNotes(viewModel: NoteViewModel?) {
        Log.d("Teste", "getAllNotes is called")
        val result = viewModel?.getNotes()
        result?.let { output?.onNotesReceived(result) } ?: run { output?.onNotesError("error getting notes") }
        /*
        doAsync {
            val result = viewModel?.getNotes()

            uiThread {
                result?.let { output?.onNotesReceived(result) } ?: run { output?.onNotesError("error getting notes") }
            }
        }
        */
    }

    override fun unregister() {
        output = null
    }
}