# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Changed

- **Build tooling**: bumped Android Gradle Plugin to `9.1.1`, Gradle wrapper to `9.3.1`
  (the minimum Gradle version AGP 9.1.1 requires), and Kotlin to `2.4.20`. Removed the
  `org.jetbrains.kotlin.android` plugin, since Kotlin support is now built into AGP 9.0+;
  `kotlin-parcelize` and KSP are still applied explicitly.
- **SDK levels**: raised `compileSdk`/`targetSdk` to `37` (required by current `core-ktx`
  and Glide releases) and `minSdk` to `24`, removing the now-unnecessary Multidex and
  `androidx.legacy:legacy-support-v4` dependencies.
- **Dependency updates** across the board via the version catalog
  (`gradle/libs.versions.toml`): Hilt `2.59.2`, Room `2.8.5`, Retrofit `3.0.0`, OkHttp
  logging-interceptor `4.12.0`, Gson `2.14.0`, Glide `5.0.9`, AndroidX Core KTX `1.19.0`,
  AppCompat `1.8.0`, Material Components `1.14.0`, ConstraintLayout `2.2.2`, Navigation
  `2.10.1`, Fragment `1.9.0`, Lifecycle `2.11.0`.
- **UI theme**: migrated from Material Components 2 (`Theme.MaterialComponents.*`) to
  **Material 3** (`Theme.Material3.DayNight.NoActionBar`), added a full light/dark Material 3
  color scheme, and enabled **dynamic color** (Material You) on Android 12+ via
  `DynamicColors.applyToActivitiesIfAvailable`.
- **Architecture**: introduced a `domain/usecase` layer (`GetExampleListUseCase`) so
  ViewModels no longer depend on repositories directly; `HomeViewModel` now exposes a
  sealed `HomeUiState` (`Loading`/`Success`/`Error`) via `StateFlow` instead of `LiveData`,
  collected lifecycle-safely from `HomeFragment` with `repeatOnLifecycle`.
- Fixed a type-erasure bug in `Resource.Success` (was `data: Any`, now correctly generic
  `data: T`).
- Wired a working example RecyclerView list end-to-end in `HomeFragment`/`fragment_home.xml`.
- Wired `SessionManager`/`SessionManagerImp` into the Hilt dependency graph and corrected
  their package declaration (they previously lived under a stray `com.wiseria.*` package).
- Enabled Gradle build cache and configuration cache in `gradle.properties`.
- Added missing test dependencies (JUnit, AndroidX Test, Espresso, kotlinx-coroutines-test)
  that were referenced by the existing test sources but never declared.

### Fixed

- `NetworkUtil.kt` was missing its `package` declaration.
- `ExampleDao.insert()` declared a nullable `@Insert` parameter, which Room/KSP now rejects.
- `getDefaultProguardFile("proguard-android.txt")` was replaced with
  `proguard-android-optimize.txt`, since the former is no longer supported by current AGP.
- Removed dead/unused code: an unused, never-assigned `SharedPreferences` field in
  `BaseActivity`, a deprecated `Handler()` call without a `Looper` in `ProgressDialog`, and
  unused drawable/layout resources (`toolbar.xml`, `button_background.xml`,
  `edittext_background.xml`, `progress_background.xml`).
- Deduplicated the `Context`/`View`/`String` extension functions that existed twice
  (once under `util/`, once under `common/extensions/`).

### Added

- `.github/workflows/ci.yml` GitHub Actions workflow running `./gradlew build`/`test` on
  every push and pull request.
- `.github/ISSUE_TEMPLATE/bug_report.md`, `.github/ISSUE_TEMPLATE/feature_request.md`, and
  `.github/PULL_REQUEST_TEMPLATE.md`.
- `CONTRIBUTING.md`, `CODE_OF_CONDUCT.md` (Contributor Covenant v2.1), and this
  `CHANGELOG.md`.

## [1.0.0] - Initial template

- Initial public MVVM template: Kotlin, Hilt, Room, Retrofit, Coroutines, LiveData,
  ViewModel, View Binding, Jetpack Navigation.
