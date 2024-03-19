plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(project(":common:games:api"))
            implementation(project(":common:core"))
        }
    }
}

android {
    namespace = "com.tishukoff.playzonekmp.common.games.data"
}