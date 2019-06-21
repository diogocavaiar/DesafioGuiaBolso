package diogo.com.br.desafioguiabolson.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import diogo.com.br.data.di.DataModule
import diogo.com.br.data.di.NetworkModule
import diogo.com.br.data.di.RepositoryModule
import diogo.com.br.desafioguiabolson.di.ActivityBindingsModule
import diogo.com.br.desafioguiabolson.di.module.AppModule
import diogo.com.br.domain.di.DomainModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBindingsModule::class, AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}