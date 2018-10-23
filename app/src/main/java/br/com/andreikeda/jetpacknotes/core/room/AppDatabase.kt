package br.com.andreikeda.jetpacknotes.core.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.andreikeda.jetpacknotes.core.room.dao.NoteDao
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity

private const val DB_NAME = "note_db"
private const val DB_VERSION = 1

@Database(entities = [NoteEntity::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }

    }

    abstract fun getNoteDao() : NoteDao

}