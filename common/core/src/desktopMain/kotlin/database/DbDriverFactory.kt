package database

import PlatformConfiguration
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

actual class DatabaseDriverFactory actual constructor(private val platformConfiguration: PlatformConfiguration) {
    actual suspend fun provideDbDriver(scheme: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver =
        JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).also { scheme.create(it).await() }
}
