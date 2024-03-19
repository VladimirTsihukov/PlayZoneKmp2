package sqldelight

import com.tishukoff.playzonekmp.Database
import database.DatabaseDriverFactory

class SqlDelightGamesDataSource(private val dbDriverFactory: DatabaseDriverFactory) {

    suspend fun test () {
        val database = Database(dbDriverFactory.provideDbDriver(Database.Schema))
        val result = database.gamesQueries.selectAll().executeAsList()
        println("result: $result")
    }
}