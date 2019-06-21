package diogo.com.br.data.datasource.categories.remote

import diogo.com.br.domain.entities.Categories
import io.reactivex.Single

interface CategoriesRemoteDataSource {
    fun getCategories(): Single<List<Categories>>
}