package br.com.andreikeda.jetpacknotes.list.view

import androidx.lifecycle.LiveData
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

interface NotesView {
    fun configureViews()
    fun hideLoading()
    fun showError(errorMessage: String)
    fun showLoading()
    fun setAdapter(notes: LiveData<List<NoteEntity>>)
}