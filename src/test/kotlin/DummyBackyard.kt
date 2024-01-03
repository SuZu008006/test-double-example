package com.example.testdoubleexample

import java.lang.RuntimeException

class DummyBackyard: Backyard {
    override fun findItem(itemName: String): String {
        throw RuntimeException()
    }
}