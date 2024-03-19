plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:core"))
            implementation(project(":common:core-compose"))
            implementation(project(":common:core-utils"))
            implementation(project(":common:auth:compose"))
            implementation(project(":common:games:api"))
            implementation(project(":common:main:compose"))
            implementation(project(":common:umbrella:core"))
            implementation(project(":common:umbrella:compose"))

            implementation(libs.odyssey.core)
            implementation(libs.odyssey.compose)
        }

        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"

        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb,
            )

            packageName = "Playzone-Admin"
            packageVersion = "1.0.0"

            windows {
                menuGroup = "PlayZone Admin"
                upgradeUuid = "b4a2e68b-9d6b-41ba-8e75-fa1df0c7cf0f"
            }
        }
    }
}