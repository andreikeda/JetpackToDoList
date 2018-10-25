package br.com.andreikeda.jetpacknotes.create.presenter

import android.app.Application

interface CreateNotePresenter {
    fun onActivityCreated()
    fun onCreateClicked(title: String?, description: String?, application: Application)
    fun unregister()
}