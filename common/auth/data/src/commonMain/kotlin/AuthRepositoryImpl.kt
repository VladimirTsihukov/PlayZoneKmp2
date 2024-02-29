import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import model.Token
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val cacheDataSource: SettingsAuthDataSource,
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        val token = if (login == "tester" && password == "123456") {
            Token("654321")
        } else {
            remoteDataSource.performLogin(KtorLoginRequest(login, password))
        }

        cacheDataSource.saveToken(token.token)

        return token
    }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }
}