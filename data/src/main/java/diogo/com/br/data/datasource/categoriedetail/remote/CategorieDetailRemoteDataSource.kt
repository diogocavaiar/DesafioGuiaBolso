package diogo.com.br.data.datasource.categoriedetail.remote

import diogo.com.br.domain.entities.CategorieDetail
import io.reactivex.Single

interface CategorieDetailRemoteDataSource {

    fun getCategorieDetail(categorie: String): Single<List<CategorieDetail>>

}