pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "PlayZoneKmp2"
include(":composeApp")
include(":common:auth:api")
include(":common:auth:compose")
include(":common:auth:data")
include(":common:auth:presentation")
include(":common:core-compose")
include(":common:core-utils")
include(":common:core:api")
include(":common:games:api")
include(":common:games:data")
include(":common:main:api")
include(":common:main:compose")
include(":common:main:data")
include(":common:main:presentation")
include(":common:umbrella:compose")
include(":common:umbrella:core")