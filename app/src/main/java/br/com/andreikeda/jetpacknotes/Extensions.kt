package br.com.andreikeda.jetpacknotes

import android.app.Activity
import android.content.Intent
import br.com.andreikeda.jetpacknotes.list.view.NotesActivity

fun Activity.startNotesActivity() {
    startActivity(Intent(this, NotesActivity::class.java))
}