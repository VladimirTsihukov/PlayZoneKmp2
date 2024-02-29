import ktor.KtorGamesDataSource
import ktor.models.mapToGame
import models.Game

class GamesRepositoryImp(
    private val remoteDataSource: KtorGamesDataSource,
): GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        return remoteDataSource.fetchAllGames().map { it.mapToGame() }
    }

    override suspend fun searchGame(query: String): List<Game> {
        return remoteDataSource.searchGame(query)
    }
}