import Ktor.ktorModule
import database.databaseModule
import json.serializationModule
import org.kodein.di.DI
import settings.settingsModule

val coreModule = DI.Module("coreModule") {
    importAll(
        databaseModule,
        ktorModule,
        serializationModule,
        settingsModule,
    )
}