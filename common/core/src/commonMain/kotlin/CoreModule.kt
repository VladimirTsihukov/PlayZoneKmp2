import Ktor.ktorModule
import database.databaseModule
import json.serializationModule
import org.kodein.di.DI

val coreModule = DI.Module("coreModule") {
    importAll(
        //databaseModule,
        ktorModule,
        serializationModule,
    )
}