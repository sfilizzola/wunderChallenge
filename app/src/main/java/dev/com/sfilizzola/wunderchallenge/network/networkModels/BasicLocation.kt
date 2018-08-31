package dev.com.sfilizzola.wunderchallenge.network.networkModels

data class BasicLocation (var address:String,
                          var coordinates: ArrayList<Double>,
                          var engineType:String,
                          var exterior:String,
                          var fuel:Int,
                          var interior:String,
                          var name:String,
                          var vin:String )