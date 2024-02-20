package ktor

import kotlinx.serialization.Serializable

@Serializable
class KtorLoginRequest(
    val login: String,
    val password: String,
)
