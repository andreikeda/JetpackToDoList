package br.com.andreikeda.jetpacknotes.core.repository

import android.app.Application
import androidx.lifecycle.LiveData
import br.com.andreikeda.jetpacknotes.core.room.AppDatabase
import br.com.andreikeda.jetpacknotes.core.room.dao.NoteDao
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity
import br.com.andreikeda.jetpacknotes.core.NoteViewModel
import org.jetbrains.anko.doAsync

class NoteRepositoryImpl(application: Application) : NoteViewModel {

    private val noteDao: NoteDao? = AppDatabase.getDatabase(application)?.getNoteDao()
    private val mAllNotes: LiveData<List<NoteEntity>>? = noteDao?.getAllNotes()

    override fun createNote(note: NoteEntity) {
        doAsync {
            noteDao?.createNote(note)
        }
    }

    override fun deleteNote(note: NoteEntity) {
        doAsync {
            noteDao?.deleteNote(note)
        }
    }

    override fun deleteAllNotes() {
        doAsync {
            noteDao?.deleteAll()
        }
    }

    override fun getNotes(): LiveData<List<NoteEntity>>? {
        return mAllNotes
    }

    override fun updateNote(note: NoteEntity) {
        doAsync {
            noteDao?.updateNote(note)
        }
    }

}