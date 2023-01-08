package com.choius323.afreecatest.di

import com.choius323.data.repository.BroadRepositoryImpl
import com.choius323.domain.repository.BroadRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsBroadRepository(repository: BroadRepositoryImpl): BroadRepository
}