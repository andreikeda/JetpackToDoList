package br.com.andreikeda.jetpacknotes.core.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import br.com.andreikeda.jetpacknotes.core.NoteViewModel
import br.com.andreikeda.jetpacknotes.core.repository.NoteRepositoryImpl
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

class NoteViewModelImpl(application: Application) : AndroidViewModel(application),
    NoteViewModel {

    private val mRepository: NoteViewModel = NoteRepositoryImpl(application)

    override fun createNote(note: NoteEntity) {
        mRepository.createNote(note)
    }

    override fun deleteNote(note: NoteEntity) {
        mRepository.deleteNote(note)
    }

    override fun deleteAllNotes() {
        mRepository.deleteAllNotes()
    }

    override fun getNotes(): LiveData<List<NoteEntity>>? {
        return mRepository.getNotes()
    }

    override fun updateNote(note: NoteEntity) {
        mRepository.updateNote(note)
    }

}