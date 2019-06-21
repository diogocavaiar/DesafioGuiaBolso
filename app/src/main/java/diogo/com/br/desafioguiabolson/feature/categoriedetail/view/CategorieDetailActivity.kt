package diogo.com.br.desafioguiabolson.feature.categoriedetail.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import diogo.com.br.desafioguiabolson.R
import diogo.com.br.desafioguiabolson.base.BaseActivity
import diogo.com.br.desafioguiabolson.feature.categoriedetail.adapter.CategorieDetailAdapter
import diogo.com.br.desafioguiabolson.feature.categoriedetail.presenter.CategorieDetailPresenterImpl
import diogo.com.br.desafioguiabolson.util.Constants
import diogo.com.br.desafioguiabolson.util.GenericException
import diogo.com.br.desafioguiabolson.util.State
import kotlinx.android.synthetic.main.activity_categorie_detail.*
import kotlinx.android.synthetic.main.activity_error_connection.*

class CategorieDetailActivity : BaseActivity<CategorieDetailPresenterImpl>(), CategorieDetailView, CategorieDetailView.OnClickLink {

    private val mAdapter = CategorieDetailAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObserve()
        initListener()
    }

    override fun getIdLayout(): Int {
        return R.layout.activity_categorie_detail
    }

    override fun initView() {
        activity_categorie_detail_recyclerView.layoutManager = LinearLayoutManager(this)
        activity_categorie_detail_recyclerView.adapter = mAdapter
    }

    override fun onPause() {
        super.onPause()
        mPresenter.unsubscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe()
    }

    private fun initListener() {
        activity_categories_btnRetry.setOnClickListener {
            mPresenter.loadData()
        }
    }

    private fun initObserve() {
        mPresenter.response.observe(this, Observer { response ->
            when(response?.state) {
                State.SUCCESS -> {
                    if(response.data.isNullOrEmpty()) {
                        showComponentEmpty()
                        return@Observer
                    }
                    mAdapter.setListCategorieDetail(response.data!!)
                }
                State.ERROR -> {
                    showImageViewError()
                    showTextViewError(GenericException.getErrorMessage(response.error!!))
                    showButtonRetry()
                }
            }
        })
    }

    override fun navigationToUrlSelected(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun getCategorieTitle(): String {
        return intent?.extras?.getString(Constants.CATEGORIE_TITLE)?:""
    }

    private fun showComponentEmpty() {
        activity_categorie_detail_empty.visibility = ConstraintLayout.VISIBLE
    }

    override fun showProgress() {
        activity_categorie_detail_progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgress() {
        activity_categorie_detail_progressBar.visibility = ProgressBar.GONE
    }

    private fun showImageViewError() {
        activity_categories_imageView.visibility = ImageView.VISIBLE
    }

    private fun showTextViewError(error: String) {
        activity_categories_tvError.visibility = TextView.VISIBLE
        activity_categories_tvError.text = error
    }

    private fun showButtonRetry() {
        activity_categories_btnRetry.visibility = Button.VISIBLE
    }

    override fun hideComponentsError() {
        activity_categories_imageView.visibility = ImageView.GONE
        activity_categories_tvError.visibility = TextView.GONE
        activity_categories_btnRetry.visibility = Button.GONE
    }

}