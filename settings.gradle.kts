pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "pangu-compose"

include(
    ":pangu-compose-foundation",
    ":pangu-compose-material2",
    ":pangu-compose-material3",
    ":pangu-compose-rui",
)

// Local development consumes sibling checkouts of pangu.kt and RUI without publishing.
// When a directory is absent, the declared Maven coordinates are resolved instead.
listOf("../pangu-kt", "../rui-compose")
    .map { file(it) }
    .filter { it.exists() }
    .forEach { includeBuild(it) }
