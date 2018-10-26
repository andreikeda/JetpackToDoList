package br.com.andreikeda.jetpacknotes.list.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.andreikeda.jetpacknotes.R
import br.com.andreikeda.jetpacknotes.RC_CREATE_NOTE
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity
import br.com.andreikeda.jetpacknotes.list.presenter.NotesPresenter
import br.com.andreikeda.jetpacknotes.list.presenter.NotesPresenterImpl
import br.com.andreikeda.jetpacknotes.list.view.adapter.NotesAdapter
import kotlinx.android.synthetic.main.activity_notes.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class NotesActivity : AppCompatActivity(), NotesView {

    private var presenter: NotesPresenter? = null
    private var showSuccessMsg = false

    override fun configureViews() {
        fab.onClick { presenter?.onCreateNoteClicked() }
    }

    override fun hideLoading() {
        linearLayout_loading.visibility = View.GONE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            RC_CREATE_NOTE -> {
                if (resultCode == Activity.RESULT_OK) {
                    showSuccessMsg = true
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        presenter = NotesPresenterImpl(this)
        presenter?.onActivityCreated()
    }

    override fun onResume() {
        super.onResume()

        if (showSuccessMsg) {
            longToast(R.string.success_note_created)
            showSuccessMsg = false
        }
    }

    override fun showError(errorMessage: String) {
        longToast(errorMessage)
    }

    override fun showLoading() {
        linearLayout_loading.visibility = View.VISIBLE
    }

    override fun setAdapter(notes: LiveData<List<NoteEntity>>) {
        notes.observe(this, Observer<List<NoteEntity>> {
            val adapter = NotesAdapter(this)
            adapter.setData(it)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        })
    }

}