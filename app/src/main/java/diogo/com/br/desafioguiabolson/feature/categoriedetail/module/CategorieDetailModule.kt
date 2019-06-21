package diogo.com.br.desafioguiabolson.feature.categoriedetail.module

import dagger.Binds
import dagger.Module
import diogo.com.br.desafioguiabolson.feature.categoriedetail.presenter.CategorieDetailPresenter
import diogo.com.br.desafioguiabolson.feature.categoriedetail.presenter.CategorieDetailPresenterImpl
import diogo.com.br.desafioguiabolson.feature.categoriedetail.view.CategorieDetailActivity
import diogo.com.br.desafioguiabolson.feature.categoriedetail.view.CategorieDetailView

@Module
abstract class CategorieDetailModule {

    @Binds
    abstract fun providesCategorieDetailActivity(categorieDetailActivity: CategorieDetailActivity): CategorieDetailView

    @Binds
    abstract fun providesCategorieDetailPresenter(categorieDetailPresenterImpl: CategorieDetailPresenterImpl): CategorieDetailPresenter

}