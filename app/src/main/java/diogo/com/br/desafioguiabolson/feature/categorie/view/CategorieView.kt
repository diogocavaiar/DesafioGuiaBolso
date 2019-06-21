package diogo.com.br.desafioguiabolson.feature.categorie.view

interface CategorieView {

    fun showProgress()

    fun hideProgress()

    fun hideComponentsError()

    interface OnClickCategorie {
        fun navigationToCategorieDetail(categorie: String)
    }

}