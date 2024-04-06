plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(project(":common:auth:api"))
            api(project(":common:core"))
            api(project(":common:games:api"))

            implementation(libs.kviewmodel.core)
        }
    }
}

android {
    namespace = "com.tishukoff.playzonekmp.common.auth.presentation"
}