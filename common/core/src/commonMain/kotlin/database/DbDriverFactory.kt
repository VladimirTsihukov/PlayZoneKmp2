package database

import PlatformConfiguration
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema

expect class DatabaseDriverFactory(platformConfiguration: PlatformConfiguration) {
    suspend fun provideDbDriver(scheme: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver
}
