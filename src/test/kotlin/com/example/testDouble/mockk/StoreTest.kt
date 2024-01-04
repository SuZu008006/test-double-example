package com.example.testDouble.mockk

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StoreTest {

    @Autowired
    lateinit var store: Store

    @MockkBean
    lateinit var mockBackyard: Backyard

    @Test
    fun dummyTest() {
        // arrange
        every {
            mockBackyard.findItem(any())
        } throws RuntimeException()

        // act
        assertThrows<RuntimeException> {
            store.searchItem("")
        }
    }

    @Test
    fun spyTest() {
        // arrange
        val unusedReturnValue = ""
        every {
            mockBackyard.findItem(any())
        } returns unusedReturnValue

        // act
        val expectedItemName = "eternal youth"
        store.searchItem(expectedItemName)

        // assert
        verify {
            mockBackyard.findItem(expectedItemName)
        }
    }

    @Test
    fun stubTest() {
        // arrange
        val expectedItemLocation = "area 13"
        every {
            mockBackyard.findItem(any())
        } returns expectedItemLocation

        // act
        val unusedArgumentValue = ""
        val actualItemLocation = store.searchItem(unusedArgumentValue)

        // assert
        assertEquals(expectedItemLocation, actualItemLocation)
    }
}
