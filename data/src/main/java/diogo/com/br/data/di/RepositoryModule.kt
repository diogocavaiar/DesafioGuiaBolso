package diogo.com.br.data.di

import dagger.Module
import dagger.Provides
import diogo.com.br.data.datasource.api.ServerApi
import diogo.com.br.data.datasource.categoriedetail.remote.CategorieDetailRemoteDataSource
import diogo.com.br.data.datasource.categoriedetail.remote.CategorieDetailRemoteDataSourceImpl
import diogo.com.br.data.datasource.categories.remote.CategoriesRemoteDataSource
import diogo.com.br.data.datasource.categories.remote.CategoriesRemoteDataSourceImpl
import diogo.com.br.data.repository.CategorieDetailRepositoryImpl
import diogo.com.br.data.repository.CategoriesRepositoryImpl
import diogo.com.br.domain.repository.CategorieDetailRepository
import diogo.com.br.domain.repository.CategoriesRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesCategoriesRemoteDataSource(api: ServerApi): CategoriesRemoteDataSource {
        return CategoriesRemoteDataSourceImpl(serverApi = api)
    }

    @Provides
    @Singleton
    fun providesCategoriesRepository(remote: CategoriesRemoteDataSource): CategoriesRepository {
        return CategoriesRepositoryImpl(remote)
    }

    @Provides
    @Singleton
    fun providesCategorieDetailRemoteDataSource(api: ServerApi): CategorieDetailRemoteDataSource {
        return CategorieDetailRemoteDataSourceImpl(serverApi = api)
    }

    @Provides
    @Singleton
    fun providesCategorieDetailRepository(remote: CategorieDetailRemoteDataSource): CategorieDetailRepository {
        return CategorieDetailRepositoryImpl(remote)
    }

}