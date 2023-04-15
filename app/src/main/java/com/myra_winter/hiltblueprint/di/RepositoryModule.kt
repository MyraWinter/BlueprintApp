package com.myra_winter.hiltblueprint.di

import com.myra_winter.hiltblueprint.data.repository.wizardingRepo.ElixirsRepository
import com.myra_winter.hiltblueprint.data.repository.wizardingRepo.ElixirsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesNoteRepository(
        noteRepositoryImpl: ElixirsRepositoryImpl,
    ): ElixirsRepository
}

