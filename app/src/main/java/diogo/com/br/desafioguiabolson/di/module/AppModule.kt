package diogo.com.br.desafioguiabolson.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @Named("mainThread")
    fun provides() : Scheduler {
        return AndroidSchedulers.mainThread()
    }

}