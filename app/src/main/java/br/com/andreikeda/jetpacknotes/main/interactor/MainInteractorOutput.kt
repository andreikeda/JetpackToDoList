package br.com.andreikeda.jetpacknotes.main.interactor

interface MainInteractorOutput {
    fun onDatabaseOpened()
    fun onDatabaseError(errorMessage: String)
}