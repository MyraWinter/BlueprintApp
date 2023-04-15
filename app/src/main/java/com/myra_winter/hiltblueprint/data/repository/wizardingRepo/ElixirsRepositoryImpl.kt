package com.myra_winter.hiltblueprint.data.repository.wizardingRepo

import com.myra_winter.hiltblueprint.data.model.ElixirModel
import com.myra_winter.hiltblueprint.data.remote.WizardingApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Repository Implementation to make the Retrofit calls
 */
class ElixirsRepositoryImpl @Inject constructor(
    private val retrofitService: WizardingApiService,
) : ElixirsRepository {


    override suspend fun getElixirs(): Flow<List<ElixirModel>> = flow {
        emit(retrofitService.getAllElixirs())
    }.flowOn(Dispatchers.IO)


}