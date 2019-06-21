package diogo.com.br.data.repository

import diogo.com.br.data.datasource.categories.remote.CategoriesRemoteDataSource
import diogo.com.br.domain.entities.Categories
import diogo.com.br.domain.repository.CategoriesRepository
import io.reactivex.Single

class CategoriesRepositoryImpl(private val remote: CategoriesRemoteDataSource) : CategoriesRepository {

    override fun getCategories(): Single<List<Categories>> {
        return remote.getCategories()
    }
}