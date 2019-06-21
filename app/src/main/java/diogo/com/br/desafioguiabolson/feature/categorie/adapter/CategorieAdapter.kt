package diogo.com.br.desafioguiabolson.feature.categorie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import diogo.com.br.desafioguiabolson.R
import diogo.com.br.desafioguiabolson.feature.categorie.view.CategorieView
import diogo.com.br.domain.entities.Categories

class CategorieAdapter(val mCallback: CategorieView.OnClickCategorie) : RecyclerView.Adapter<CategorieViewHolder>(), OnClickCategorie {

    var mListCategories: ArrayList<Categories> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorieViewHolder {
        return CategorieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_categories_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mListCategories.size
    }

    override fun onBindViewHolder(holder: CategorieViewHolder, position: Int) {
        holder.bind(mListCategories[position], this)
    }

    fun setListCategories(categories: List<Categories>) {
        mListCategories.addAll(categories)
        notifyDataSetChanged()
    }

    override fun clickCategorie(categorie: String) {
        mCallback.navigationToCategorieDetail(categorie)
    }

}