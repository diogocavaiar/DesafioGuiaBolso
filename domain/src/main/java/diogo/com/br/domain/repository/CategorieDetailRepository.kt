package diogo.com.br.domain.repository

import diogo.com.br.domain.entities.CategorieDetail
import io.reactivex.Single

interface CategorieDetailRepository {

    fun getCategorieDetail(categorie: String): Single<List<CategorieDetail>>

}