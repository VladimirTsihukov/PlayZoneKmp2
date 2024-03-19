plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.core)
        }
    }
}

android {
    namespace = "com.tishukoff.playzonekmp.common.auth.api"
}