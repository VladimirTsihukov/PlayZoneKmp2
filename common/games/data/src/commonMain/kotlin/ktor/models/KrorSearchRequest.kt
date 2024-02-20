package ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class KrorSearchRequest (
    val searchQuery: String,
)