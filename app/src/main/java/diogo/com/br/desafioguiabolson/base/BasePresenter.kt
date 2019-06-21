package diogo.com.br.desafioguiabolson.base

import androidx.lifecycle.MutableLiveData
import diogo.com.br.desafioguiabolson.util.Response

open class BasePresenter<T> : BasePresenterOut() {

    val response: MutableLiveData<Response<T>> = MutableLiveData()

    override fun loadData() {}

}