package br.com.andreikeda.jetpacknotes.list.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import br.com.andreikeda.jetpacknotes.R
import br.com.andreikeda.jetpacknotes.core.room.entity.NoteEntity
import br.com.andreikeda.jetpacknotes.list.presenter.NotesPresenter
import br.com.andreikeda.jetpacknotes.list.presenter.NotesPresenterImpl
import br.com.andreikeda.jetpacknotes.list.view.adapter.NotesAdapter
import kotlinx.android.synthetic.main.activity_notes.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class NotesActivity : AppCompatActivity(), NotesView {

    private var presenter: NotesPresenter? = null

    override fun configureViews() {
        fab.onClick { presenter?.onCreateNoteClicked() }
    }

    override fun hideLoading() {
        linearLayout_loading.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        presenter = NotesPresenterImpl(this)
        presenter?.onActivityCreated(application)
    }

    override fun showError(errorMessage: String) {
        longToast(errorMessage)
    }

    override fun showLoading() {
        linearLayout_loading.visibility = View.VISIBLE
    }

    override fun setAdapter(notes: LiveData<List<NoteEntity>>) {
        notes.value?.let {
            val adapter = NotesAdapter(this)
            adapter.setData(it)
            recyclerView.adapter = adapter
        }
    }

}