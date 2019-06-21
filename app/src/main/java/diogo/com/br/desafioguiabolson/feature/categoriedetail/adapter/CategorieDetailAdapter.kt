package diogo.com.br.desafioguiabolson.feature.categoriedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import diogo.com.br.desafioguiabolson.R
import diogo.com.br.desafioguiabolson.feature.categoriedetail.view.CategorieDetailView
import diogo.com.br.domain.entities.CategorieDetail

class CategorieDetailAdapter(val callback: CategorieDetailView.OnClickLink) : RecyclerView.Adapter<CategorieDetailViewHolder>(), OnClickLinkUrl {

    var mListCategorieDetail: ArrayList<CategorieDetail> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorieDetailViewHolder {
        return CategorieDetailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_categorie_detail_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mListCategorieDetail.size
    }

    override fun onBindViewHolder(holder: CategorieDetailViewHolder, position: Int) {
        holder.bind(mListCategorieDetail[position], this)
    }

    fun setListCategorieDetail(categories: List<CategorieDetail>) {
        mListCategorieDetail.addAll(categories)
        notifyDataSetChanged()
    }

    override fun onClickLink(url: String) {
        callback.navigationToUrlSelected(url)
    }
}