package br.com.andreikeda.jetpacknotes.list.presenter

import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

interface NotesPresenter {
    fun onActivityCreated()
    fun onCreateNoteClicked()
    fun onChangedNoteChecked(note: NoteEntity, isChecked: Boolean)
    fun unregister()
}