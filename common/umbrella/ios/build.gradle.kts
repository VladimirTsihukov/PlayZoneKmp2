plugins {
    id("multiplatform-setup")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin {
    cocoapods {
        summary = "PlayZone iOS SDK"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            baseName = "SharedSDK"

            export(project(":common:auth:api"))
            export(project(":common:auth:presentation"))
            export(project(":common:core"))
            export(project(":common:core-utils"))
            export(project(":common:games:api"))
            export(project(":common:main:api"))
            export(project(":common:main:presentation"))
            export(project(":common:umbrella:core"))
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":common:auth:api"))
            implementation(project(":common:auth:presentation"))
            implementation(project(":common:core"))
            implementation(project(":common:core-utils"))
            implementation(project(":common:main:api"))
            implementation(project(":common:main:presentation"))
            implementation(project(":common:umbrella:core"))
        }

        iosMain.dependencies {
            api(project(":common:auth:api"))
            api(project(":common:auth:presentation"))
            api(project(":common:core"))
            api(project(":common:core-utils"))
            api(project(":common:main:api"))
            api(project(":common:main:presentation"))
            api(project(":common:umbrella:core"))
        }
    }
}

android {
    namespace = "com.tishukoff.playzonekmp.common.umbrella.ios"
}