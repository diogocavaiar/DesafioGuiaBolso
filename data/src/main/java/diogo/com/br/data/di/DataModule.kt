package diogo.com.br.data.di

import dagger.Module

@Module(includes = [NetworkModule::class, RepositoryModule::class])
class DataModule