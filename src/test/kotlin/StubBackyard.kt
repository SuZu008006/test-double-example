package com.example.testdoubleexample

class StubBackyard: Backyard {
    var returnedItemLocation: String = ""

    override fun findItem(itemName: String): String {
        return returnedItemLocation
    }
}