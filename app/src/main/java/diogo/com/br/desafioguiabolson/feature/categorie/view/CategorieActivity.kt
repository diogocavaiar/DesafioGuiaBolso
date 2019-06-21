package diogo.com.br.desafioguiabolson.feature.categorie.view

import android.content.Intent
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
import diogo.com.br.desafioguiabolson.feature.categorie.adapter.CategorieAdapter
import diogo.com.br.desafioguiabolson.feature.categorie.presenter.CategoriePresenterImpl
import diogo.com.br.desafioguiabolson.feature.categoriedetail.view.CategorieDetailActivity
import diogo.com.br.desafioguiabolson.util.Constants
import diogo.com.br.desafioguiabolson.util.GenericException
import diogo.com.br.desafioguiabolson.util.State
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_error_connection.*

class CategorieActivity : BaseActivity<CategoriePresenterImpl>(), CategorieView, CategorieView.OnClickCategorie {

    private val mAdapter = CategorieAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListener()
        initObserve()
    }

    override fun getIdLayout(): Int {
        return R.layout.activity_categories
    }

    override fun initView() {
        activity_categories_recyclerView.layoutManager = LinearLayoutManager(this)
        activity_categories_recyclerView.adapter = mAdapter
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
                    mAdapter.setListCategories(response.data!!)
                }
                State.ERROR -> {
                    showImageViewError()
                    showTextViewError(GenericException.getErrorMessage(response.error!!))
                    showButtonRetry()
                }
            }
        })
    }

    private fun showComponentEmpty() {
        activity_categories_empty.visibility = ConstraintLayout.VISIBLE
    }

    override fun showProgress() {
        activity_categories_progressBar!!.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgress() {
        activity_categories_progressBar!!.visibility = ProgressBar.GONE
    }

    override fun navigationToCategorieDetail(categorie: String) {
       val intent = Intent(this, CategorieDetailActivity::class.java)
        intent.putExtra(Constants.CATEGORIE_TITLE, categorie)
        startActivity(intent)
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