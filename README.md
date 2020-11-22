# Movies-App

### Structure of the code ###
Simple Android Application written in Kotlin.
This project follows Clean Architecture with MVVM with Clean Architecture Design


# Main libraries used

* Data Binding
* Dagger2
* RxJava2
* Retrofit2
* Paging 3.0
* Timber
* Room
* Junit
* Espresso
* Mockito
* Glide
* Glide Platte
* Navigation Component
* sdp library (for universal screen resolution)
* shimmer effect lib
* Android Architecture component Jetpack


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


##TODO
setup for room db for offline storage of data
adding more filter option for the movie list
adding more unit test cases
improving the design





