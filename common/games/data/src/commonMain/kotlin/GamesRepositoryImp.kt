import ktor.KtorGamesDataSource
import ktor.models.mapToGame
import models.CreateGameInfo
import models.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImp(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataBase: SqlDelightGamesDataSource,
): GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        //return remoteDataSource.fetchAllGames().map { it.mapToGame() }
        return listOf(Game("1","Doom"), Game("2","GTA 5"), Game("3","Dota 2"))
    }

    override suspend fun searchGame(query: String): List<Game> {
        localDataBase.test()
        return remoteDataSource.searchGame(query)
    }

    override suspend fun createGame(token: String, info: CreateGameInfo) {
        //TODO("Need API for save game")
    }
}