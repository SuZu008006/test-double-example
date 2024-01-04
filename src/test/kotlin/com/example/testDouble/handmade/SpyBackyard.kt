package com.example.testDouble.handmade

class SpyBackyard: Backyard {
    var argumentItemName: String? = null

    override fun findItem(itemName: String): String {
        argumentItemName = itemName
        return ""
    }
}