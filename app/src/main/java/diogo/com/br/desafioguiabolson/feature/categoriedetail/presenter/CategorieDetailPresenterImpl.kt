package diogo.com.br.desafioguiabolson.feature.categoriedetail.presenter

import diogo.com.br.desafioguiabolson.base.BasePresenter
import diogo.com.br.desafioguiabolson.feature.categoriedetail.view.CategorieDetailView
import diogo.com.br.desafioguiabolson.util.Response
import diogo.com.br.desafioguiabolson.util.State
import diogo.com.br.domain.entities.CategorieDetail
import diogo.com.br.domain.usecase.GetCategorieDetailUseCase
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class CategorieDetailPresenterImpl @Inject constructor(
    private val view: CategorieDetailView,
    private val getCategorieDetailUseCase: GetCategorieDetailUseCase,
    @Named("mainThread") private val uiScheduler: Scheduler) : BasePresenter<List<CategorieDetail>>(), CategorieDetailPresenter {

    override fun loadData() {
        getCategorieDetailUseCase.execute(view.getCategorieTitle(), uiScheduler, {
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
        getCategorieDetailUseCase.unsubscribe()
    }
}