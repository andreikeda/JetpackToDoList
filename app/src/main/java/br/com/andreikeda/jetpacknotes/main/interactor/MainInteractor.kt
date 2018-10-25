package br.com.andreikeda.jetpacknotes.main.interactor

import android.app.Application

interface MainInteractor {
    fun openDatabase(application: Application)
    fun unregister()
}