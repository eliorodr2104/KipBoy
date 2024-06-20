rootProject.name = "KipBoy"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://josm.openstreetmap.de/nexus/content/repositories/releases/") // Add this line for JOSM
        maven(url = "https://jogamp.org/deployment/maven") // add this also
    }


    plugins {
        kotlin("jvm").version(extra["kotlin.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://josm.openstreetmap.de/nexus/content/repositories/releases/") // Add this line for JOSM
        maven(url = "https://jogamp.org/deployment/maven") // add this also
    }
}

include(":composeApp")