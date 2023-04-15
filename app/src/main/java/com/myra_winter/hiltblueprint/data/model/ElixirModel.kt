package com.myra_winter.hiltblueprint.data.model


/**
 * Elixir Model
 *
 * Learning Resources
 * Converter to Kotlin Data class https://json2kt.com/
 */

data class ElixirModel(
    var id: String? = null,
    var name: String? = null,
    var effect: String? = null,
    var sideEffects: String? = null,
    var characteristics: String? = null,
    var time: String? = null,
    var difficulty: String? = null,
    var ingredients: List<Ingredients> = arrayListOf(),
    var inventors: List<Inventors> = arrayListOf(),
    var manufacturer: String? = null,
)

data class Ingredients(
    var id: String? = null,
    var name: String? = null,
)

data class Inventors(
    var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
)
