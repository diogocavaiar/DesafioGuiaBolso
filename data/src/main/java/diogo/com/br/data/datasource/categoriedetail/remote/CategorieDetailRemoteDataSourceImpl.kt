package diogo.com.br.data.datasource.categoriedetail.remote

import diogo.com.br.data.datasource.api.ServerApi
import diogo.com.br.data.datasource.categoriedetail.remote.mapper.ResponseCategorieDetailMapper
import diogo.com.br.domain.entities.CategorieDetail
import io.reactivex.Single

class CategorieDetailRemoteDataSourceImpl(private val serverApi: ServerApi) : CategorieDetailRemoteDataSource {
    override fun getCategorieDetail(categorie: String): Single<List<CategorieDetail>> {
        return serverApi.fetchCategorieDetail(categorie)
            .map {
                ResponseCategorieDetailMapper.map(it)
            }
    }
}