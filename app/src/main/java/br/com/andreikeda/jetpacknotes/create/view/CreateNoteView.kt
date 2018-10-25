package br.com.andreikeda.jetpacknotes.create.view

interface CreateNoteView {
    fun configureViews()
    fun showSuccess()
    fun showError(errorMessage: String)
}