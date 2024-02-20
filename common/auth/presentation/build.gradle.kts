plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:api"))
                implementation(project(":common:core"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:games:api"))

                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}