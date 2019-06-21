package diogo.com.br.desafioguiabolson

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import diogo.com.br.desafioguiabolson.di.component.DaggerAppComponent

class MyApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}