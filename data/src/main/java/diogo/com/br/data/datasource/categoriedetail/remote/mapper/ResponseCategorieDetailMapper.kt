package diogo.com.br.data.datasource.categoriedetail.remote.mapper

import diogo.com.br.data.datasource.categoriedetail.remote.model.ResponseCategorieDetail
import diogo.com.br.data.datasource.categoriedetail.remote.model.ResponseCategorieDetailResult
import diogo.com.br.domain.entities.CategorieDetail

object ResponseCategorieDetailMapper {

    fun map(response: ResponseCategorieDetail) = response.result.map { map(it) }

    private fun map(response: ResponseCategorieDetailResult) = CategorieDetail(
        response.icon,
        response.phrase,
        response.link
    )

}