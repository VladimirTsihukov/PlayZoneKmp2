import model.Token

interface AuthRepository {

    suspend fun login(login: String, password: String): Token
    fun isUserLoggedIn(): Boolean

    fun fetchToken(): String
}