package br.com.andreikeda.jetpacknotes.list.router

import android.app.Activity
import br.com.andreikeda.jetpacknotes.startCreateNoteActivity

class NotesRouterImpl(var activity: Activity?) : NotesRouter {
    override fun goToCreateNoteScreen() {
        activity?.startCreateNoteActivity()
    }

    override fun unregister() {
        activity = null
    }

}