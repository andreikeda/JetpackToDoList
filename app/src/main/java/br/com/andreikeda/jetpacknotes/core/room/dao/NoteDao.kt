package br.com.andreikeda.jetpacknotes.core.room.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

private const val QUERY_SELECT_ALL = "select * from notes"

@Dao
interface NoteDao {

    @Query(QUERY_SELECT_ALL)
    fun getAllNotes() : List<NoteEntity>

    @Insert(onConflict = REPLACE)
    fun createNote(note: NoteEntity)

    @Update
    fun updateNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

}