package br.com.andreikeda.jetpacknotes.list.presenter

interface NotesPresenter {
    fun onActivityCreated()
    fun onCreateNoteClicked()
    fun unregister()
}