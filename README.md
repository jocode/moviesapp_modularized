# MoviesApp Modularized

This is an example for a modularized architecture movies app. This modularization is based on feature layered modularization, that means that **each feature is a module and each module has its own layers (data, domain, presentation)**.

## 1. Creating our `buildSrc` module

The first step is to create a `buildSrc` module. This module will contain all the configuration that we will use in our project, like the version of the app. This module will be imported in our `build.gradle` file in the root of our project.

- Change the view to `Project` in the Android Studio Project view.
- Create a new directory called `buildSrc` in the root of the project.
- Create a new file called `build.gradle.kts` in the `buildSrc` directory.
- Add the following code to the `build.gradle.kts` file:

```kotlin
import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    mavenCentral()
}

plugins {
    `kotlin-dsl`
}
```

- Now create a new directories called `src/main/kotlin` or `src/main/java` in the `buildSrc` directory.
- Create a new file called `Dependencies.kt` or the name that you prefers in the `src/main/kotlin` directory.


## 2. Creating our Version Catalog file in the `gradle` folder

[Gradle version catalogs](https://developer.android.com/build/migrate-to-catalogs) enable you to add and maintain dependencies and plugins in a scalable way. Using Gradle version catalogs makes managing dependencies and plugins easier when you have multiple modules. Instead of hardcoding dependency names and versions in individual build files and updating each entry whenever you need to upgrade a dependency, you can create a central version catalog of dependencies that various modules can reference in a type-safe way with Android Studio assistance.

Version Catalog `libs.version.toml` is a file that contains all the versions of the dependencies that we will use in our project.

- Create a file called `libs.versions.toml` in the `gradle` folder.
- Add all the dependencies that you need. The structure of the file is the following:
    - **versions**: In the versions block, define variables that hold the versions of your dependencies and plugins. You use these variables in the subsequent blocks (the versions and plugins blocks).
    - **libraries**: In the libraries block, define your dependencies.
    - **plugins**: In the plugins block, define your plugins.
    - **bundles**: In the bundles block, define your dependency bundles, which are groups of dependencies that you can import together.
