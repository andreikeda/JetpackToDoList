package br.com.andreikeda.jetpacknotes.main.presenter

import android.app.Application

interface MainPresenter {
    fun onActivityCreated()
    fun onEnterButtonClicked(application: Application)
    fun unregister()
}