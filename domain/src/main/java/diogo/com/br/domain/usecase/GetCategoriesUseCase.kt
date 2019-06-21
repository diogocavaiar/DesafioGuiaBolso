package diogo.com.br.domain.usecase

import diogo.com.br.domain.entities.Categories
import diogo.com.br.domain.repository.CategoriesRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetCategoriesUseCase(private val repository: CategoriesRepository) : SingleUseCase<List<Categories>, Unit>() {
    override fun buildUseCase(params: Unit?): Single<List<Categories>> {
        return repository.getCategories()
    }
}