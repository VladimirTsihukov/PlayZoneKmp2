plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:core"))
            implementation(project(":common:core-utils"))

            implementation(project(":common:auth:data"))
            implementation(project(":common:games:data"))

            implementation(libs.kodein.di)
        }
    }
}

android {
    namespace = "com.tishukoff.playzonekmp.common.umbrella.core"
}