package com.example.testDouble.handmade

interface Backyard {
    fun findItem(itemName: String): String
}

class BackyardImpl : Backyard {
    override fun findItem(itemName: String): String {
        TODO("Not yet implemented")
    }
}
