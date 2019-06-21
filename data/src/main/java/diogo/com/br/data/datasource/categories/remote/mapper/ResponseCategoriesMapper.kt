package diogo.com.br.data.datasource.categories.remote.mapper

import diogo.com.br.domain.entities.Categories

object ResponseCategoriesMapper {

    fun map(response: List<String>) = response.map {
        map(it)
    }

    private fun map(categorie: String) = Categories(categorie)

}