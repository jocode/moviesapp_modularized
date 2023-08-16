package com.core.network.model


import com.squareup.moshi.Json

data class ProductionCompany(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "logo_path")
    val logoPath: Any,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "origin_country")
    val originCountry: String,
)