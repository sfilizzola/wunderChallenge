package dev.com.sfilizzola.wunderchallenge.models

data class Car(var address:String,
               var coordinates: ArrayList<Double>,
               var engineType:String,
               var exterior:String,
               var fuel:Int,
               var interior:String,
               var name:String,
               var vin:String )