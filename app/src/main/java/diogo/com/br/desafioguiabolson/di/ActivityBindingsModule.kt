package diogo.com.br.desafioguiabolson.di

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import diogo.com.br.desafioguiabolson.di.scope.PerActivity
import diogo.com.br.desafioguiabolson.feature.categorie.module.CategorieModule
import diogo.com.br.desafioguiabolson.feature.categorie.view.CategorieActivity
import diogo.com.br.desafioguiabolson.feature.categoriedetail.module.CategorieDetailModule
import diogo.com.br.desafioguiabolson.feature.categoriedetail.view.CategorieDetailActivity

@Module(includes = [AndroidInjectionModule::class])
abstract class ActivityBindingsModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [CategorieModule::class])
    abstract fun categoriesActivityInjector(): CategorieActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [CategorieDetailModule::class])
    abstract fun categorieDetailActivityInjector(): CategorieDetailActivity

}