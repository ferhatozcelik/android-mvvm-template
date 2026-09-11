# Android MVVM Template

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![minSdk](https://img.shields.io/badge/minSdk-24-brightgreen.svg)](app/build.gradle)
[![compileSdk](https://img.shields.io/badge/compileSdk-37-brightgreen.svg)](app/build.gradle)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.4.20-7F52FF.svg?logo=kotlin)](https://kotlinlang.org)

A modern, production-ready **MVVM (Model-View-ViewModel)** starter template for native Android
applications, built with Kotlin, Coroutines/Flow, Hilt, Room, Retrofit and Material 3. It is meant
to be cloned or used as a GitHub template for new projects, giving you a clean architectural
baseline instead of a blank Android Studio project.

## Features

- **MVVM + Clean layering** — `UI (Fragment/Activity) -> ViewModel -> UseCase -> Repository -> DataSource`
- **Kotlin Coroutines + `StateFlow`** — ViewModels expose immutable `StateFlow<UiState>` instead of
  `LiveData`, following a `Loading / Success / Error` sealed `UiState` pattern
- **Hilt** for compile-time-safe dependency injection across app, ViewModel and repository layers
- **Room** for local persistence with a `Flow`/suspend-based DAO
- **Retrofit + OkHttp** for type-safe networking, wired through a repository that merges cached and
  remote data
- **Jetpack Navigation Component** with Safe Args for type-safe fragment navigation
- **View Binding** everywhere — no `findViewById`, no synthetic imports
- **Material 3** theming, including **dynamic color** (Material You) support on Android 12+, with
  proper light/dark color schemes
- **Version catalog** (`gradle/libs.versions.toml`) as the single source of truth for dependency
  versions
- Ready-to-use issue templates and PR template

## Architecture

The app follows MVVM with an additional thin **use case (domain)** layer so ViewModels never talk
to repositories directly:

```
UI layer            ui/fragments/*, ui/activitys/*, ui/adapters/*
                     Fragments/Activities render a sealed UiState via View Binding.
        │
        ▼
ViewModel layer      ui/fragments/*/*ViewModel.kt
                     Exposes state as StateFlow<UiState>, drives the use case in viewModelScope.
        │
        ▼
Domain layer         domain/usecase/*, domain/repository/*
                     Use cases hold single business rules; repository interfaces are
                     defined here so the domain layer has no Android/data-layer dependencies.
        │
        ▼
Data layer           data/repository/*, data/dao/*, data/services/*, data/local/*
                     Repository implementations combine Room (cache) and Retrofit (remote),
                     wrapping results in Resource<T> (Loading/Success/Error).
```

### Folder structure

```
app/src/main/java/com/ferhatozcelik/androidmvvmtemplate/
├── common/                 # Cross-cutting helpers: preferences, session, extensions
├── data/
│   ├── dao/                 # Room DAOs
│   ├── entity/               # Room entities
│   ├── local/                # Room database + type converters
│   ├── model/                 # Network DTOs + Resource<T> wrapper
│   ├── repository/            # Repository implementations
│   └── services/               # Retrofit service interfaces
├── di/                     # Hilt modules (network, database, preferences, repositories)
├── domain/
│   ├── repository/          # Repository interfaces (used by use cases/ViewModels)
│   └── usecase/               # Single-responsibility business rules
├── interfaces/             # Small shared contracts (e.g. click listeners)
├── ui/
│   ├── activitys/            # Activities
│   ├── adapters/              # RecyclerView adapters
│   ├── base/                   # BaseActivity / BaseFragment / BaseAdapter (View Binding)
│   └── fragments/              # Feature screens, each with its own ViewModel
└── util/                   # General utilities and extension functions
```

## Tech stack

| Component | Library | Version |
|---|---|---|
| Language | Kotlin | 2.4.20 |
| Build system | Android Gradle Plugin | 9.1.1 |
| Build tool | Gradle | 9.3.1 |
| Dependency injection | Hilt (Dagger) | 2.59.2 |
| Async | Kotlin Coroutines / Flow | 1.10.2 |
| Local persistence | Room | 2.8.5 |
| Networking | Retrofit / OkHttp | 3.0.0 / 4.12.0 |
| JSON | Gson | 2.14.0 |
| Image loading | Glide | 5.0.9 |
| UI | Material Components (Material 3) | 1.14.0 |
| Navigation | Jetpack Navigation (Safe Args) | 2.10.1 |
| Lifecycle / ViewModel | AndroidX Lifecycle | 2.11.0 |

> Exact versions are pinned in [`gradle/libs.versions.toml`](gradle/libs.versions.toml) — that file
> is the source of truth if it ever diverges from this table.

### SDK levels

| | Value |
|---|---|
| `minSdk` | 24 (Android 7.0) |
| `targetSdk` | 37 |
| `compileSdk` | 37 |

## Getting started

### Prerequisites

- Android Studio (latest stable) or the command line with JDK 17+
- Android SDK Platform 37 installed

### Clone and build

```bash
git clone https://github.com/ferhatozcelik/android-mvvm-template.git
cd android-mvvm-template

# Build a debug APK
./gradlew assembleDebug

# Run unit tests
./gradlew test

# Run static analysis (Android Lint)
./gradlew lint

# Full build (assemble + test + lint)
./gradlew build
```

Then open the project in Android Studio and run the `app` configuration, or install the generated
APK directly:

```bash
./gradlew installDebug
```

### Using this as a template

1. Rename the package `com.ferhatozcelik.androidmvvmtemplate` to your own application ID.
2. Replace the sample `Example*` classes (entity, DAO, model, repository, use case) with your own
   domain objects, keeping the same layering.
3. Point `BASE_URL` in `util/Constants.kt` to your backend.
4. Update `app_name`, launcher icons and the color palette in `res/values/colors.xml` to match your
   brand — the rest of the Material 3 theme will adapt automatically (including dynamic color).

## Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for the workflow (fork,
branch, PR), commit message conventions, and code style expectations before opening a pull request.
This project also follows the [Contributor Covenant Code of Conduct](CODE_OF_CONDUCT.md).

See [CHANGELOG.md](CHANGELOG.md) for a history of notable changes.

## License

This project is licensed under the Apache License 2.0 — see the [LICENSE](LICENSE) file for
details.

## Author

👤 Ferhat OZCELIK

- GitHub: [@ferhatozcelik](https://github.com/ferhatozcelik)
- LinkedIn: [Ferhat OZCELIK](https://www.linkedin.com/in/ferhatozcelik/)

If you found this template helpful, please consider giving it a ⭐️ on GitHub. Your support is
greatly appreciated!
