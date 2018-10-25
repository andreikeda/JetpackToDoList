package br.com.andreikeda.jetpacknotes.create.view

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andreikeda.jetpacknotes.R
import br.com.andreikeda.jetpacknotes.create.presenter.CreateNotePresenter
import br.com.andreikeda.jetpacknotes.create.presenter.CreateNotePresenterImpl
import kotlinx.android.synthetic.main.activity_create.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class CreateNoteActivity : AppCompatActivity(), CreateNoteView {

    private var presenter: CreateNotePresenter? = CreateNotePresenterImpl(this)

    override fun configureViews() {
        button_create.onClick {
            presenter?.onCreateClicked(textInputEditText_title.text?.toString(), textInputEditText_description.text?.toString(), application)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        presenter = CreateNotePresenterImpl(this)
        presenter?.onActivityCreated()
    }

    override fun onDestroy() {
        presenter?.unregister()
        presenter = null

        super.onDestroy()
    }

    override fun showSuccess() {
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun showError(errorMessage: String) {
        longToast(errorMessage)
    }
}