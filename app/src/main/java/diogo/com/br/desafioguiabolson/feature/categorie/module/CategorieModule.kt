package diogo.com.br.desafioguiabolson.feature.categorie.module

import dagger.Binds
import dagger.Module
import diogo.com.br.desafioguiabolson.feature.categorie.presenter.CategoriePresenter
import diogo.com.br.desafioguiabolson.feature.categorie.presenter.CategoriePresenterImpl
import diogo.com.br.desafioguiabolson.feature.categorie.view.CategorieActivity
import diogo.com.br.desafioguiabolson.feature.categorie.view.CategorieView

@Module
abstract class CategorieModule {

    @Binds
    abstract fun providesCategorieActivity(categorieActivity: CategorieActivity): CategorieView

    @Binds
    abstract fun providesCategoriePresenter(categoriePresenterImpl: CategoriePresenterImpl): CategoriePresenter

}