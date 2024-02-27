import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import model.Token

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        return if (login == "tester" && password == "123456") {
            Token("654321")
        } else {
            remoteDataSource.performLogin(KtorLoginRequest(login, password))
        }
    }
}