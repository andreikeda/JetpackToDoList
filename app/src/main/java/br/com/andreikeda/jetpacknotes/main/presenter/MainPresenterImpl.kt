package br.com.andreikeda.jetpacknotes.main.presenter

import android.app.Activity
import android.app.Application
import br.com.andreikeda.jetpacknotes.main.interactor.MainInteractor
import br.com.andreikeda.jetpacknotes.main.interactor.MainInteractorImpl
import br.com.andreikeda.jetpacknotes.main.interactor.MainInteractorOutput
import br.com.andreikeda.jetpacknotes.main.router.MainRouter
import br.com.andreikeda.jetpacknotes.main.router.MainRouterImpl
import br.com.andreikeda.jetpacknotes.main.view.MainView

class MainPresenterImpl(var view: MainView?) : MainPresenter, MainInteractorOutput {

    private var interactor: MainInteractor? = MainInteractorImpl(this)
    private var router: MainRouter? = MainRouterImpl(view as Activity)

    override fun onActivityCreated() {
        view?.configureViews()
    }

    override fun onEnterButtonClicked(application: Application) {
        interactor?.openDatabase(application)
    }

    override fun unregister() {
        interactor?.unregister()
        interactor = null
        router?.unregister()
        router = null
        view = null
    }

    override fun onDatabaseOpened() {
        router?.goToListScreen()
    }

    override fun onDatabaseError(errorMessage: String) {
        view?.showError(errorMessage)
    }

}