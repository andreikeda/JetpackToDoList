package br.com.andreikeda.jetpacknotes.core.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

private const val QUERY_DELETE_ALL = "delete from notes"
private const val QUERY_SELECT_ALL = "select * from notes ORDER BY time_in_millis DESC"

@Dao
interface NoteDao {

    @Insert(onConflict = REPLACE)
    fun createNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

    @Query(QUERY_DELETE_ALL)
    fun deleteAll()

    @Query(QUERY_SELECT_ALL)
    fun getAllNotes() : LiveData<List<NoteEntity>>

    @Update
    fun updateNote(note: NoteEntity)

}