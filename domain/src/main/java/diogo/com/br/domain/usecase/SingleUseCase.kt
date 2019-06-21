package diogo.com.br.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params> {

    private val disposables = CompositeDisposable()

    abstract fun buildUseCase(params: Params? = null): Single<T>

    open fun execute(
        params: Params? = null,
        uiScheduler: Scheduler,
        doOnSubscribe: () -> Unit,
        doAfterTerminate: () -> Unit,
        onSuccess: (T) -> Unit,
        onError: (e: Throwable) -> Unit) {
        val observable = this.buildUseCase(params)
        addDisposable(observable
            .subscribeOn(Schedulers.io())
            .observeOn(uiScheduler)
            .doOnSubscribe{
                doOnSubscribe.invoke()
            }
            .doAfterTerminate {
                doAfterTerminate.invoke()
            }
            .subscribe({
                onSuccess?.invoke(it)
            },
                {
                    onError?.invoke(it)
                }
            )
        )
    }

    fun unsubscribe() {
        disposables.clear()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}