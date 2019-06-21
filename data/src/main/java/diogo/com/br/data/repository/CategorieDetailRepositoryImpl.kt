package diogo.com.br.data.repository

import diogo.com.br.data.datasource.categoriedetail.remote.CategorieDetailRemoteDataSource
import diogo.com.br.domain.entities.CategorieDetail
import diogo.com.br.domain.repository.CategorieDetailRepository
import io.reactivex.Single

class CategorieDetailRepositoryImpl(private val remote: CategorieDetailRemoteDataSource) : CategorieDetailRepository {
    override fun getCategorieDetail(categorie: String): Single<List<CategorieDetail>> {
        return remote.getCategorieDetail(categorie)
    }
}