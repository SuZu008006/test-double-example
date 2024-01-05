package com.example.testDouble.handmade

interface Store {
    fun searchItem(itemName: String): String
}

class StoreImpl(
    private val backyard: Backyard
) : Store {
    override fun searchItem(itemName: String): String {
        return backyard.findItem(itemName)
    }
}
