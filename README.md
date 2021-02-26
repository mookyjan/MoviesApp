# Movies-App

### Structure of the code ###
Simple Android Application written in Kotlin.
This project follows Clean Architecture with MVVM with Clean Architecture Design


# Main libraries used

- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Rxjava](https://github.com/ReactiveX/RxJava) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding) - Used for data binding 
  - [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) - Used it for the navigation from one fragment to another fragments
  - [Room](https://developer.android.com/reference/androidx/room/package-summary) -Used for local data storage
  - [Paging 3.0](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) -to load large amount of data in chunks instead to load all the records in one api call. Paging 3.0 will automatically call the api to laod more data when user reached to end of the screen.
- [Dependency Injection](https://developer.android.com/training/dependency-injection)
  - [Dagger2](https://dagger.dev/) - Standard library to incorporate Dagger dependency injection into an Android application. 
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Glide](https://bumptech.github.io/glide/) - Used for loading images
- [Sdp Library](https://github.com/intuit/sdp) -Used for auto Layout for different layouts
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Timber](https://github.com/JakeWharton/timber) -Used for loggging 
- [Junit](https://junit.org/) - For Unit Testing
- [Mockito](https://github.com/mockito/mockito) - For mocking in Unit Testing


# Architecture Design
![alt text](https://github.com/mookyjan/MoviesApp/blob/main/diagram/clean%20architecture%20design.png)

![alt text](https://github.com/mookyjan/MoviesApp/blob/main/diagram/clean-mvvm.png)

![alt text](https://github.com/mookyjan/MoviesApp/blob/main/diagram/project%20structure.png)


# Modules


* `data/` : contains the code to access to the data (repository pattern)
* `domain/` : contains the business logic and the usecases
* `app` : Presentation layer, contains the UI 

this project consist of Two screen. on the first screen showing the list of movies list and on clicking the item
go to the details of the movie.
Swipe to Refresh can be used to refresh data and when user scroll new list of movies will be automatically
and for the simplicity of this project many things have been kept simple
like 
* ErrorHandling, 
* Internet connectivity and 
* Design of the app is also kept sample and can be improved much more

comments are written with the function that what it will do.

also TODO are given in the area which we can improve more.

# Screenshots
![alt text](https://github.com/mookyjan/MoviesApp/blob/main/screenshots/device-2020-11-22-184042.png)

![alt text](https://github.com/mookyjan/MoviesApp/blob/main/screenshots/device-2020-11-23-073954.png)

![alt text](https://github.com/mookyjan/MoviesApp/blob/main/screenshots/device-2020-11-23-081505.png)


##TODO

setup for room db for offline storage of data
adding more filter option for the movie list
adding more unit test cases
setup for CI/CD
improving the design





