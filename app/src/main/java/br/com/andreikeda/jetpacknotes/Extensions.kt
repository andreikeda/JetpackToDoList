package br.com.andreikeda.jetpacknotes

import android.app.Activity
import android.content.Intent
import br.com.andreikeda.jetpacknotes.create.view.CreateNoteActivity
import br.com.andreikeda.jetpacknotes.list.view.NotesActivity

const val RC_CREATE_NOTE = 111

fun Activity.startCreateNoteActivity() {
    startActivityForResult(Intent(this, CreateNoteActivity::class.java), RC_CREATE_NOTE)
}

fun Activity.startNotesActivity() {
    startActivity(Intent(this, NotesActivity::class.java))
}