package com.choius323.afreecatest.di

import com.choius323.data.datasource.remote.BroadRemoteDataSource
import com.choius323.data.datasource.remote.BroadRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindsBroadRemoteDataSourceModule(dataSource: BroadRemoteDataSourceImpl): BroadRemoteDataSource
}