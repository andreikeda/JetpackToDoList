package br.com.andreikeda.jetpacknotes.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andreikeda.jetpacknotes.R
import br.com.andreikeda.jetpacknotes.main.presenter.MainPresenter
import br.com.andreikeda.jetpacknotes.main.presenter.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null

    override fun configureViews() {
        button_enter.onClick { presenter?.onEnterButtonClicked(application) }
    }

    override fun showError(errorMessage: String) {
        longToast(errorMessage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenterImpl(this)
        presenter?.onActivityCreated()
    }

    override fun onDestroy() {
        presenter?.unregister()
        presenter = null

        super.onDestroy()
    }
}
