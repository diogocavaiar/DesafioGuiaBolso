package diogo.com.br.desafioguiabolson.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<P: BasePresenterOut> : DaggerAppCompatActivity() {

    @Inject
    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getIdLayout())
        initView()
        loadValues()
    }

    private fun loadValues() {
        mPresenter.loadData()
    }

    abstract fun initView()

    abstract fun getIdLayout(): Int


}