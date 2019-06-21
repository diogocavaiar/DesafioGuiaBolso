package diogo.com.br.data.datasource.categoriedetail.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseCategorieDetail(@SerializedName("total") val total: Int,
                                   @SerializedName("result") val result: List<ResponseCategorieDetailResult>)