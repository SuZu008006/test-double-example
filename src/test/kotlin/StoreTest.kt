package com.example.testdoubleexample

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StoreTest {
    @Test
    fun `dummyのテスト`() {
        // arrange
        val dummyBackyard = DummyBackyard()
        val store = StoreImpl(dummyBackyard)

        // assert
        assertThrows<RuntimeException> {
            // act
            store.searchItem("")
        }
    }

    @Test
    fun `spyのテスト`() {
        // arrange
        val spyBackyard = SpyBackyard()
        val store = StoreImpl(spyBackyard)

        // act
        val expectedItemName = "hoge"
        store.searchItem(expectedItemName)

        // assert
        assertEquals(expectedItemName, spyBackyard.argumentItemName)
    }

    @Test
    fun `stubのテスト`() {
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