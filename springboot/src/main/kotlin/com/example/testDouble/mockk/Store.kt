package com.example.testDouble.mockk

import org.springframework.stereotype.Component

interface Store {
    fun searchItem(itemName: String): String
}

@Component
class StoreImpl(
    private val backyard: Backyard
) : Store {
    override fun searchItem(itemName: String): String {
        return backyard.findItem(itemName)
    }
}
