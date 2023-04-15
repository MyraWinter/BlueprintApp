package com.myra_winter.hiltblueprint.data.remote

import com.myra_winter.hiltblueprint.data.model.ElixirModel
import retrofit2.http.GET

/**
 * Retrofit API Service
 *
 * Learning Resources
 * API: https://wizard-world-api.herokuapp.com/swagger/index.html
 */
interface WizardingApiService {

    companion object {
        const val baseUrl = "https://wizard-world-api.herokuapp.com/"
    }

    @GET("Elixirs")
    suspend fun getAllElixirs(): List<ElixirModel>


}