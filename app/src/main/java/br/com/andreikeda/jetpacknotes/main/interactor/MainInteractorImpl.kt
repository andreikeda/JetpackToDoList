package br.com.andreikeda.jetpacknotes.main.interactor

import android.app.Application
import org.jetbrains.anko.doAsync

class MainInteractorImpl(var output: MainInteractorOutput?) : MainInteractor {
    override fun openDatabase(application: Application) {
        doAsync {

        }
    }

    override fun unregister() {
        output = null
    }

}