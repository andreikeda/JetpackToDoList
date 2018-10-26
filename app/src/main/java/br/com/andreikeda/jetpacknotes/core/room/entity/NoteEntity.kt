package br.com.andreikeda.jetpacknotes.core.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NoteEntity(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "note_id") val noteId: Long? = null, val name: String, val description: String, @ColumnInfo(name = "time_in_millis") val timeInMillis: Long, @ColumnInfo(name = "is_finished") var isFinished: Boolean) {
    constructor() : this(null, "", "", 0, false)
}