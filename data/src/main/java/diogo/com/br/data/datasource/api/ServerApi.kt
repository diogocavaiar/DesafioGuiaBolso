package diogo.com.br.data.datasource.api

import diogo.com.br.data.datasource.categoriedetail.remote.model.ResponseCategorieDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerApi {

    @GET("categories")
    fun fetchCategories(): Single<List<String>>

    @GET("search")
    fun fetchCategorieDetail(@Query("query")categorie: String): Single<ResponseCategorieDetail>

}