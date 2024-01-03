package com.example.testdoubleexample

interface Customer {
    fun getItem()
}

class CustomerImpl(
    private val store: Store
):Customer {
    override fun getItem() {
        TODO("Not yet implemented")
    }
}