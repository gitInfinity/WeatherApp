package com.plcoding.weatherapp.di

import com.plcoding.weatherapp.data.remote.location.DefaultLocationTracker
import com.plcoding.weatherapp.data.remote.repository.WeatherRepoImplementation
import com.plcoding.weatherapp.domain.location.LocationTracker
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepoImplementation): WeatherRepository
}