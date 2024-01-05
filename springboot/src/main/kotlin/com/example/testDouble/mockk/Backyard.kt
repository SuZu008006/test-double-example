package com.example.testDouble.mockk

import org.springframework.stereotype.Component

interface Backyard {
    fun findItem(itemName: String): String
}

@Component
class BackyardImpl : Backyard {
    override fun findItem(itemName: String): String {
        TODO("Not yet implemented")
    }
}
