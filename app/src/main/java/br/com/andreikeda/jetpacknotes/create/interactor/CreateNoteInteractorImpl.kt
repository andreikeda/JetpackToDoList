package br.com.andreikeda.jetpacknotes.create.interactor

import br.com.andreikeda.jetpacknotes.core.NoteViewModel
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CreateNoteInteractorImpl(var output: CreateNoteInteractorOutput?) : CreateNoteInteractor {
    override fun createNote(viewModel: NoteViewModel?, note: NoteEntity) {
        doAsync {
            viewModel?.createNote(note)

            uiThread {
                output?.onCreateSuccess()
            }
        }
    }

    override fun unregister() {
        output = null
    }
}