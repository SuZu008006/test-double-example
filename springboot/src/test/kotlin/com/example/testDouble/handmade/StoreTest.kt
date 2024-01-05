package com.example.testDouble.handmade

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StoreTest {
    @Test
    fun dummyTest() {
        // arrange
        val dummyBackyard = DummyBackyard()
        val store = StoreImpl(dummyBackyard)

        // assert
        assertThrows<RuntimeException> {
            // act
            val unusedArgumentValue = ""
            store.searchItem(unusedArgumentValue)
        }
    }

    @Test
    fun spyTest() {
        // arrange
        val spyBackyard = SpyBackyard()
        val store = StoreImpl(spyBackyard)

        // act
        val expectedItemName = "eternal youth"
        store.searchItem(expectedItemName)

        // assert
        assertEquals(expectedItemName, spyBackyard.argumentItemName)
    }

    @Test
    fun stubTest() {
        // arrange
        val stubBackyard = StubBackyard()
        val expectedItemLocation = "area 13"
        stubBackyard.returnedItemLocation = expectedItemLocation
        val store = StoreImpl(stubBackyard)

        // act
        val unusedArgument = ""
        val actualItemLocation = store.searchItem(unusedArgument)

        // assert
        assertEquals(expectedItemLocation, actualItemLocation)
    }
}
