package diogo.com.br.data.datasource.categories.remote

import diogo.com.br.data.datasource.api.ServerApi
import diogo.com.br.data.datasource.categories.remote.mapper.ResponseCategoriesMapper
import diogo.com.br.domain.entities.Categories
import io.reactivex.Single

class CategoriesRemoteDataSourceImpl(private val serverApi: ServerApi) : CategoriesRemoteDataSource {

    override fun getCategories(): Single<List<Categories>> {
        return serverApi.fetchCategories()
            .map {
                ResponseCategoriesMapper.map(it)
            }
    }

}