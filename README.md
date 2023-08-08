# Android MVVM Template

This is an Android project template that demonstrates the use of the MVVM (Model-View-ViewModel) architecture along with modern Android architecture components. It provides a structured starting point for building Android applications that are maintainable, testable, and scalable.

## Project Architecture

This app follows the MVVM architecture pattern, which stands for "Model-View-ViewModel." Here's an overview of each component:

- **Model:** Responsible for data and business logic. Independent of UI.
- **View:** Displays UI elements and interacts with users.
- **ViewModel:** Acts as a bridge between Model and View. Manages data presentation and user interactions. UI-independent.

MVVM promotes separation of concerns, making your codebase more organized and easier to manage. It also supports data binding, automatic synchronization of data between ViewModel and View, and allows for more effective testing.

## Technologies and Libraries Used

- [Kotlin](https://kotlinlang.org/): Programming language for Android development.
- [Hilt-Dagger](https://dagger.dev/hilt/): Dependency injection library for Android.
- [Retrofit](https://square.github.io/retrofit/): Type-safe HTTP client for networking.
- [Room](https://developer.android.com/training/data-storage/room): SQLite object mapping library for local data storage.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html): Asynchronous programming using Kotlin's coroutine framework.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): Observable data holder class for UI components.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): Stores UI-related data that survives configuration changes.
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding): Generates binding classes for XML layout files.
- [Jetpack Navigation](https://developer.android.com/guide/navigation): Handles navigation between different parts of the app.

## Getting Started

1. Clone this repository: `git clone https://github.com/ferhatozcelik/android-mvvm-template.git`
2. Open the project in Android Studio.
3. Build and run the app.

Feel free to customize and extend this template to match the requirements of your specific project.

## Author

👤 Ferhat OZCELIK

- GitHub: [@ferhatozcelik](https://github.com/ferhatozcelik)
- LinkedIn: [Ferhat OZCELIK](https://www.linkedin.com/in/ferhatozcelik/)

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

If you found this template helpful, please consider giving it a ⭐️ on GitHub. Your support is greatly appreciated!
