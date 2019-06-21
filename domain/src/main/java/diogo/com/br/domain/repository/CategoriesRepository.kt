package diogo.com.br.domain.repository

import diogo.com.br.domain.entities.Categories
import io.reactivex.Single

interface CategoriesRepository {

    fun getCategories(): Single<List<Categories>>

}