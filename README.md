# Wunder Challenge

## First impressions

First of all thanks for considering this code, it was very pleasant to make it, and I've learned a lot!

## Architectural decisions

The App is using MVVM with Databinding, today is the "go-to" architecture for me in Android, is some simples Apps, can be too much. But I think in this case can show things that I know and if the App was made in a simpler way, maybe I don't have ways to show that.

The main reason for using MVVM is making logic, models and layers of the aplication more testable, together with dependency injection the classes became even more apart from eatch other.

## App structure

Although the app is very simple I've choose to go with a Main Activity and replace tha central content with two fragments, the list and the map view, according with the option selected on a BottonNavigationView.

## React and LiveData

The main comunication between layers of the app occur using RxJava and LiveData, all the data from "outside the app", Database and Network, goes via a Stream until reach the viewmodel Layer that uses a LiveData to comunicate with the views.

### Why not use RxJava all the way ?

The reason to use LiveData from the ViewModel foward is that LiveData is Lifecycle Aware, meaning that he knows wich state is the Activity and/or Fragment of the user, so that way if something happens is the user layer the Stream of data can act properly with the current conditions of the app, for example when the user pauses the Activity by pressing the home twice.

## Unit tests

As the challenge was reaching to an End all the features implemented were very simple features, so I figured out that I will be doing some dumb tests. I consider them, is this case, not important for the test objectives, but I can make them if required.

Some examples of tests that can be done in the app are:

- Check if all the resources are beeing called on CarItemRowViewmodel
- Check if the JSON on network matches the model objects.
- Check if the content on DataRepository is right.

I thik unit tests are crutial for the quality of professional apps, but I don't see any reasons for doing them on this challlenge.

## Persistance

I have implemented an Offline First Architecture usign Room and Retrofit, if the data is not persisted on local SQLite, I get the data from the network and save it locally.


### Foreword

Thanks for reaching here.

Regards,

*Samuel Filizzola*

