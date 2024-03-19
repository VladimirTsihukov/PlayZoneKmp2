plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
    id(libs.plugins.sqldilight.get().pluginId)
}

sqldelight {
    databases {
        create("Database") {
            packageName = "com.tishukoff.playzonekmp"
            generateAsync.set(true) //Needed for working JS
        }
    }
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.serialization.core)

            api(libs.ktor.client.core)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.negotiation)
            implementation(libs.ktor.client.logging)

            implementation(libs.multiplatform.settings.core)
            implementation(libs.multiplatform.settings.no.arg)

            api(libs.kodein.di)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            implementation(libs.sqldelight.android.driver)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
            implementation(libs.sqldelight.native.driver)
        }

        desktopMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.sqldelight.sqlite.driver)
        }

        jsMain.dependencies {
            implementation(libs.sqldelight.js.driver)
            implementation(npm("sql.js", "1.6.2"))
            implementation(devNpm("copy-webpack-plugin", "9.1.0"))
        }
    }
}

android {
    namespace = "com.tishukoff.playzonekmp.common.core"
}