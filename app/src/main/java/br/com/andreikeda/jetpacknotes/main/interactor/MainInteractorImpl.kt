package br.com.andreikeda.jetpacknotes.main.interactor

import android.app.Application
import br.com.andreikeda.jetpacknotes.core.repository.NoteRepositoryImpl
import org.jetbrains.anko.doAsync

class MainInteractorImpl(var output: MainInteractorOutput?) : MainInteractor {
    override fun openDatabase(application: Application) {
        doAsync {
            val liveData = NoteRepositoryImpl(application).getNotes()
            liveData?.let { output?.onDatabaseOpened() } ?: run { output?.onDatabaseError("teste") }
        }
    }

    override fun unregister() {
        output = null
    }

}