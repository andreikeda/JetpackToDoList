package br.com.andreikeda.jetpacknotes.main.router

import android.app.Activity

class MainRouterImpl(var activity: Activity?) : MainRouter {
    override fun goToListScreen() {
    }

    override fun unregister() {
        activity = null
    }

}