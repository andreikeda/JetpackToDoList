package br.com.andreikeda.jetpacknotes.list.presenter

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import br.com.andreikeda.jetpacknotes.core.NoteViewModel
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity
import br.com.andreikeda.jetpacknotes.core.viewmodel.NoteViewModelImpl
import br.com.andreikeda.jetpacknotes.list.interactor.NotesInteractor
import br.com.andreikeda.jetpacknotes.list.interactor.NotesInteractorImpl
import br.com.andreikeda.jetpacknotes.list.interactor.NotesInteractorOutput
import br.com.andreikeda.jetpacknotes.list.router.NotesRouter
import br.com.andreikeda.jetpacknotes.list.router.NotesRouterImpl
import br.com.andreikeda.jetpacknotes.list.view.NotesView

class NotesPresenterImpl(var view: NotesView?) : NotesPresenter, NotesInteractorOutput {

    private var interactor: NotesInteractor? = NotesInteractorImpl(this)
    private var noteViewModel: NoteViewModel? = ViewModelProviders.of(view as AppCompatActivity).get(NoteViewModelImpl::class.java)
    private var router: NotesRouter? = NotesRouterImpl(view as Activity)

    override fun onActivityCreated() {
        view?.configureViews()
        view?.showLoading()
        interactor?.getAllNotes(noteViewModel)
    }

    override fun onCreateNoteClicked() {
        router?.goToCreateNoteScreen()
    }

    override fun onChangedNoteChecked(note: NoteEntity, isChecked: Boolean) {
        note.isFinished = isChecked
        interactor?.updateNote(noteViewModel, note)
    }

    override fun unregister() {
        interactor?.unregister()
        interactor = null
        router?.unregister()
        router = null
        view = null
        noteViewModel = null
    }

    override fun onNotesReceived(notes: LiveData<List<NoteEntity>>) {
        view?.hideLoading()
        view?.setAdapter(notes)
    }

    override fun onNotesError(errorMessage: String) {
        view?.hideLoading()
        view?.showError(errorMessage)
    }
}