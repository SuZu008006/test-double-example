package com.example.testdoubleexample

class SpyBackyard: Backyard {
    var argumentItemName: String? = null

    override fun findItem(itemName: String): String {
        argumentItemName = itemName
        return ""
    }
}