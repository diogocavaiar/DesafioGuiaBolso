package diogo.com.br.domain.di

import dagger.Module
import dagger.Provides
import diogo.com.br.domain.repository.CategorieDetailRepository
import diogo.com.br.domain.repository.CategoriesRepository
import diogo.com.br.domain.usecase.GetCategorieDetailUseCase
import diogo.com.br.domain.usecase.GetCategoriesUseCase
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideGetCategoriesUseCase(repository: CategoriesRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCategorieDetailUseCase(repository: CategorieDetailRepository): GetCategorieDetailUseCase {
        return GetCategorieDetailUseCase(repository)
    }

}