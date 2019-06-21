package diogo.com.br.domain.usecase

import diogo.com.br.domain.entities.CategorieDetail
import diogo.com.br.domain.repository.CategorieDetailRepository
import io.reactivex.Single

class GetCategorieDetailUseCase(private val repository: CategorieDetailRepository): SingleUseCase<List<CategorieDetail>, String>() {
    override fun buildUseCase(params: String?): Single<List<CategorieDetail>> {
        if (params == null) throw IllegalArgumentException("Deve ser informado a categoria de busca") as Throwable
        return repository.getCategorieDetail(params)
    }
}