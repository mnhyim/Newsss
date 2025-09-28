# Newsss
Simple news headlines app built with Kotlin and Jetpack Compose using data from [News API](https://newsapi.org/), following the MVVM architecture.
## Tech stack
- Kotlin – Primary language for app development.
- Jetpack Compose – Used for building UI.
- Room – Used for offline persistence.
- Retrofit – HTTP client for fetching data from APIs.
- Koin – Dependency injection framework.
- Coil – Used for remote image loading.
- Moshi – JSON serialization/deserialization library.
## What I’m proud of
I’m quite proud of the offline-first setup I added, even though it wasn’t required. The way it works is simple but robust in my opinion: When the user opened the app it will try to fetch news from the API first, and if successful, it saves the data to the local Room database and pass it to the HomeViewModel. If the API call fails, it falls back to the last saved data from Room and if there’s no local data available, the app shows an error dialog with a message and an option to retry fetching from the internet.
## Challenges & Solution
- I’m not totally sure of a better way to handle the AppBar logic from MainActivity. Usually, I check if currentDestination.route matches the route’s qualified name, like ```Routes.Home::class.qualifiedName```. In the case of Detail, that doesn’t work because the route’s qualified name includes all its parameters, so for now I just check if the current route contains ```Routes.Detail``` and display the appropriate TopAppBar.
- The API doesn’t specify which parameters can be null, so for now I just set any null values to an empty string.
## Future Improvements
- In a real project I’d improve API key security by adding ```gradle.properties``` to ```.gitignore```, committing a ```gradle.properties.default``` instead, and instructing users to copy it to ```gradle.properties``` and place their API key there.
- I was thinking of modularizing the project, but decided it would be overengineering for this simple app. If I ever do modularize it in the future, I’d probably follow the structure I’ve already used in this project (modularize by feature and layer).
- I’m not super happy with how I implemented the Detail screen right now because I had to pass a lot of parameters. If the API ever adds that feature, I’d improve it by just passing the news ID from Home to Detail and letting the DetailViewModel fetch the item directly. I guess I can pass the news object directly instead but I'm not sure if that's better.