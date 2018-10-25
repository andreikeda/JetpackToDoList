package br.com.andreikeda.jetpacknotes.create.presenter

import android.app.Application
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity
import br.com.andreikeda.jetpacknotes.create.interactor.CreateNoteInteractor
import br.com.andreikeda.jetpacknotes.create.interactor.CreateNoteInteractorImpl
import br.com.andreikeda.jetpacknotes.create.interactor.CreateNoteInteractorOutput
import br.com.andreikeda.jetpacknotes.create.view.CreateNoteView
import java.util.*

class CreateNotePresenterImpl(var view: CreateNoteView?) : CreateNotePresenter, CreateNoteInteractorOutput {

    private var interactor: CreateNoteInteractor? = CreateNoteInteractorImpl(this)

    override fun onActivityCreated() {
        view?.configureViews()
    }

    override fun onCreateClicked(title: String?, description: String?, application: Application) {
        val t = title?.let { it } ?: run { "Sem título" }
        val d = description?.let { it } ?: run { "Sem descrição" }
        val note = NoteEntity(null, t, d, Calendar.getInstance().timeInMillis, false)
        interactor?.createNote(application, note)
    }

    override fun unregister() {
        interactor?.unregister()
        interactor = null
        view = null
    }

    override fun onCreateSuccess() {
        view?.showSuccess()
    }

    override fun onCreateError(errorMessage: String) {
        view?.showError(errorMessage)
    }
}