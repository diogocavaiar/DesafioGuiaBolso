package diogo.com.br.data.datasource.categories.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseCategories(@SerializedName("categories") val categories: MutableList<String>)