package br.com.andreikeda.jetpacknotes.create.interactor

interface CreateNoteInteractorOutput {
    fun onCreateSuccess()
    fun onCreateError(errorMessage: String)
}