package br.com.andreikeda.jetpacknotes.list.interactor

import android.app.Application

interface NotesInteractor {
    fun getAllNotes(application: Application)
    fun unregister()
}