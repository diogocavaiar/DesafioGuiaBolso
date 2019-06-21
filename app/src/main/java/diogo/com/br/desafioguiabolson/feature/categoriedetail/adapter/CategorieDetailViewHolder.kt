package diogo.com.br.desafioguiabolson.feature.categoriedetail.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import diogo.com.br.domain.entities.CategorieDetail
import kotlinx.android.synthetic.main.activity_categorie_detail_item.view.*

class CategorieDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(categorieDetail: CategorieDetail, listener: OnClickLinkUrl) {

        Glide.with(itemView.activity_categorie_detail_item_icon.context)
            .load(categorieDetail.icon)
            .into(itemView.activity_categorie_detail_item_icon)

        itemView.activity_categorie_detail_item_tvPhrase.text = categorieDetail.phrase
        itemView.activity_categorie_detail_item_tvLinkValue.text = categorieDetail.link

        itemView.activity_categorie_detail_item_tvLinkValue.setOnClickListener{listener.onClickLink(categorieDetail.link)}

    }

}