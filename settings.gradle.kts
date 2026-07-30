pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Just for the 3.4.1 UI release. Starting from 3.5.0 of UI modules, will be available on GitLab Package Registry.
        maven {
            url = uri("https://maven.drivequant.com/repository/android-sdk/")
        }
    }
}

rootProject.name = "DriveKit Quickstart"
include(":app")
 