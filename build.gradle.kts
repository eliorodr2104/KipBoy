import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization") version "1.8.0"

    id("org.openjfx.javafxplugin") version "0.0.10"
}

// add this also at the beginning could show you error but continue to use!
javafx {
    version = "17.0.2"
    modules = listOf(
        "javafx.controls",
        "javafx.fxml",
        "javafx.web",
        "javafx.swing"
    )
}

group = "org.kipboy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://josm.openstreetmap.de/nexus/content/repositories/releases/") // Add this line for JOSM
    maven(url = "https://jogamp.org/deployment/maven")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    implementation("uk.co.caprica:vlcj:4.8.2")

    //Raspberry [TEST]
    implementation("com.pi4j:pi4j-ktx:2.4.0") // Kotlin DSL
    implementation("com.pi4j:pi4j-core:2.6.0")
    implementation("com.pi4j:pi4j-plugin-raspberrypi:2.5.1")
    implementation("com.pi4j:pi4j-plugin-pigpio:2.5.1")

    //Serializable
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-cbor:1.5.1")

    //API Spotify
    implementation("com.adamratzman:spotify-api-kotlin-core:4.1.3")

    implementation("io.ktor:ktor-server-core:2.3.0")
    implementation("io.ktor:ktor-server-netty:2.3.0")

    implementation("org.openstreetmap.jmapviewer:jmapviewer:2.16")
    //api("io.github.qdsfdhvh:image-loader:1.7.8")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        // add this also
        // this is as i remember for default toolbar for desktop app but also add this )
        jvmArgs("--add-opens", "java.desktop/sun.awt=ALL-UNNAMED")
        jvmArgs("--add-opens", "java.desktop/java.awt.peer=ALL-UNNAMED")
        if (System.getProperty("os.name").contains("Mac")) {
            jvmArgs("--add-opens", "java.desktop/sun.lwawt=ALL-UNNAMED")
            jvmArgs("--add-opens", "java.desktop/sun.lwawt.macosx=ALL-UNNAMED")
        }

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KipBoy"
            packageVersion = "1.0.0"
        }

        // also proguard rules
        buildTypes.release.proguard {
            configurationFiles.from("compose-desktop.pro")
        }
    }
}