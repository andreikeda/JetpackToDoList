package br.com.andreikeda.jetpacknotes.main.router

import android.app.Activity
import br.com.andreikeda.jetpacknotes.startNotesActivity

class MainRouterImpl(var activity: Activity?) : MainRouter {
    override fun goToListScreen() {
        activity?.startNotesActivity()
    }

    override fun unregister() {
        activity = null
    }

}