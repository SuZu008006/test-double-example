package com.example.testDouble.handmade

class StubBackyard : Backyard {
    var returnedItemLocation: String = ""

    override fun findItem(itemName: String): String {
        return returnedItemLocation
    }
}
