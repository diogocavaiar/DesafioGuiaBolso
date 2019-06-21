package diogo.com.br.desafioguiabolson.feature.categoriedetail.view

interface CategorieDetailView {

    fun getCategorieTitle(): String

    fun showProgress()

    fun hideProgress()

    fun hideComponentsError()

    interface OnClickLink {
        fun navigationToUrlSelected(url: String)
    }

}