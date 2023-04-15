package com.myra_winter.hiltblueprint.data.repository.wizardingRepo

import com.myra_winter.hiltblueprint.data.model.ElixirModel
import kotlinx.coroutines.flow.Flow


/**
 * Repository to make the Retrofit calls
 */
interface ElixirsRepository {

    suspend fun getElixirs(): Flow<List<ElixirModel>>
}