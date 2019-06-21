package diogo.com.br.data.datasource.categoriedetail.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseCategorieDetailResult(@SerializedName("icon_url") val icon: String,
                                         @SerializedName("url") val link: String,
                                         @SerializedName("value") val phrase: String)