plugins {
    id("multiplatform-setup")
    id(libs.plugins.libres.get().pluginId)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:core-compose"))
            implementation(project(":common:core-utils"))
            implementation(project(":common:games:api"))
            implementation(project(":common:main:presentation"))

            implementation(libs.kviewmodel.core)
            implementation(libs.kviewmodel.compose)
            implementation(libs.kviewmodel.odyssey)

            implementation(libs.odyssey.core)
            implementation(libs.odyssey.compose)
        }
    }
}

android {
    namespace = "com.tishukoff.playzonekmp.common.main.compose"
}