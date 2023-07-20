# Android MVVM Template

#### A simple Template showing the use of modern android architecture component with MVVM Architecture 🏗

### Project Architecture

This app uses [MVVM (Model View View-Model)] architecture.

### MVVM (Model View View-Model)
  MVVM stands for "Model-View-ViewModel" and it is an architectural pattern used in Android app development. Here's a brief explanation of each component:

- Model: The Model represents the data and business logic of the application. It can include data structures, databases, APIs, or any other data-related logic. The Model should be independent of the user interface and the View.
- View: The View represents the user interface elements of the application. It displays the data from the Model and interacts with the user. In Android, it typically consists of XML layout files and UI components like TextViews, Buttons, RecyclerViews, etc.
- ViewModel: The ViewModel acts as an intermediary between the Model and the View. It is responsible for exposing the data from the Model to the View in a format that the View can easily consume. The ViewModel also contains the presentation logic and handles user interactions. It should not hold references to the View, making it independent of the UI framework.

MVVM promotes separation of concerns and makes the code more maintainable, testable, and scalable. It also facilitates data binding, where changes in the ViewModel are automatically reflected in the View and vice versa.
In Android development, MVVM is often implemented using frameworks like LiveData for data observation and Data Binding for connecting the View and ViewModel.


### Build With 🏗️

- [Kotlin] - Programming language for Android
- [Hilt-Dagger] - Standard library to incorporate Dagger dependency injection into an Android
  application.
- [Retrofit] - A type-safe HTTP client for Android and Java.
- [Room] - SQLite object mapping library.
- [Coroutines] - For asynchronous
- [LiveData] - Data objects that notify views when the underlying database changes.
- [ViewModel] - Stores UI-related data that isn't destroyed on UI changes.
- [ViewBinding] - Generates a binding class for each XML layout file present in that module and
  allows you to more easily write code that interacts with views.
- [Jetpack Navigation] - Navigation refers to the interactions that allow users to navigate across,
  into, and back out from the different pieces of content within your app

  [ViewModel]: <https://developer.android.com/topic/libraries/architecture/viewmodel>

  [Jetpack Navigation]: <https://developer.android.com/guide/navigation/>

  [Hilt-Dagger]: <https://dagger.dev/hilt/>

  [DataStore]: <https://developer.android.com/topic/libraries/architecture/datastore>

  [ViewBinding]: <https://developer.android.com/topic/libraries/view-binding>

  [LiveData]: <https://developer.android.com/topic/libraries/architecture/livedata/>

  [Retrofit]: <https://square.github.io/retrofit/>

  [ViewModel]: <https://developer.android.com/topic/libraries/architecture/viewmodel>

  [Kotlin]: <https://kotlinlang.org>

  [Coroutines]: <https://kotlinlang.org/docs/coroutines-overview.html>

  [MVVM (Model View View-Model)]: <https://developer.android.com/jetpack/guide#recommended-app-arch>

  [Dictionary Api]: <https://api.dictionaryapi.dev/>

  [Room]: <https://developer.android.com/training/data-storage/room/>

### Author

👤 Ferhat OZCELIK

Github: @ferhatozcelik
LinkedIn:https://www.linkedin.com/in/ferhatozcelik/
Show your support
Give a ⭐️ if this project helped you!

### License

Copyright © 2022 Ferhat OZCELIK.
This project is Apache License, Version 2.0 (the "License") licensed.
