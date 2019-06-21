package diogo.com.br.desafioguiabolson.feature.categorie.presenter

import diogo.com.br.desafioguiabolson.base.BasePresenter
import diogo.com.br.desafioguiabolson.feature.categorie.view.CategorieView
import diogo.com.br.desafioguiabolson.util.Response
import diogo.com.br.desafioguiabolson.util.State
import diogo.com.br.domain.entities.Categories
import diogo.com.br.domain.usecase.GetCategoriesUseCase
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class CategoriePresenterImpl @Inject constructor(
    private val view: CategorieView,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    @Named("mainThread") private val uiScheduler: Scheduler) : BasePresenter<List<Categories>>(),
    CategoriePresenter {

    override fun loadData() {
        getCategoriesUseCase.execute(null, uiScheduler, {
            view.hideComponentsError()
            view.showProgress()
        }, {
            view.hideProgress()
        }, {
                result -> response.postValue(Response(State.SUCCESS, result, null))
        }, {
                throwable -> response.postValue(Response(State.ERROR, null, throwable))
        })
    }

    override fun unsubscribe() {
        getCategoriesUseCase.unsubscribe()
    }
}