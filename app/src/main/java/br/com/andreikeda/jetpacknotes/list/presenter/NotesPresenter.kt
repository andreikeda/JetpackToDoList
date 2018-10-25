package br.com.andreikeda.jetpacknotes.list.presenter

import android.app.Application

interface NotesPresenter {
    fun onActivityCreated(application: Application)
    fun onCreateNoteClicked()
    fun unregister()
}