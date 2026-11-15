import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.maven.publish)
}

kotlin {
    explicitApi()
    jvmToolchain(21)

    jvm {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    android {
        namespace = "art.rippledesign.pangu.compose.foundation"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    js {
        browser()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            api("art.rippledesign:pangu:1.0.0")
            implementation(libs.compose.foundation)
        }
    }
}

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)

    if (providers.gradleProperty("signingInMemoryKey").isPresent) {
        signAllPublications()
    }

    coordinates("art.rippledesign", "pangu-compose-foundation", project.version.toString())

    pom {
        name.set("pangu-compose-foundation")
        description.set(providers.gradleProperty("pomDescription"))
        inceptionYear.set("2026")
        url.set(providers.gradleProperty("pomUrl"))

        licenses {
            license {
                name.set(providers.gradleProperty("pomLicenseName"))
                url.set(providers.gradleProperty("pomLicenseUrl"))
                distribution.set("repo")
            }
        }

        scm {
            url.set(providers.gradleProperty("pomScmUrl"))
            connection.set(providers.gradleProperty("pomScmConnection"))
            developerConnection.set(providers.gradleProperty("pomScmDeveloperConnection"))
        }

        developers {
            developer {
                id.set(providers.gradleProperty("pomDeveloperId"))
                name.set(providers.gradleProperty("pomDeveloperName"))
                url.set(providers.gradleProperty("pomDeveloperUrl"))
            }
        }
    }
}
