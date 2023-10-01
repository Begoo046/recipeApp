package com.elifbegum.myapplication.di


import com.elifbegum.myapplication.data.repo.RecipesDARepository
import com.elifbegum.myapplication.retrofit.ApiUtils
import com.elifbegum.myapplication.retrofit.RecipesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRecipesDARepository(kdao: RecipesDao): RecipesDARepository {
        return RecipesDARepository(kdao)
    }
    @Provides
    @Singleton
    fun provideRecipesDao(): RecipesDao {
        return ApiUtils.getRecipesDao()
    }
}