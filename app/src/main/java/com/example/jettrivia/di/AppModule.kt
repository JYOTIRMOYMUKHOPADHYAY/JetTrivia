package com.example.jettrivia.di

import android.util.Log
import com.example.jettrivia.network.QuestionApi
import com.example.jettrivia.repository.QuestionsRepository
import com.example.jettrivia.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionApi) = QuestionsRepository(api)

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi {
        Log.d("API", "provideQuestionApi: ")
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(QuestionApi::class.java)
    }
}