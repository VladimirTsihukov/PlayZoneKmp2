plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:auth:api"))
            implementation(project(":common:core"))
            implementation(project(":common:games:api"))

            implementation(libs.kviewmodel.core)
        }
    }
}

android {
    namespace = "com.tishukoff.playzonekmp.common.auth.presentation"
}