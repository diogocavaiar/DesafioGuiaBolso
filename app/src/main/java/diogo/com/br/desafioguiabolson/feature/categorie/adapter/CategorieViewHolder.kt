package diogo.com.br.desafioguiabolson.feature.categorie.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import diogo.com.br.domain.entities.Categories
import kotlinx.android.synthetic.main.activity_categories_item.view.*

class CategorieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(categorie: Categories, clickCategorie: OnClickCategorie) {
        itemView.activity_categories_item_title.text = categorie.categorie.toUpperCase()

        itemView.activity_categories_item_content.setOnClickListener{
            clickCategorie.clickCategorie(categorie.categorie)
        }
    }

}