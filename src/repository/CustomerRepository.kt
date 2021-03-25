package com.example.repository

import com.example.models.Customer
import java.util.*

class CustomerRepository {

    private val database = mutableListOf<Customer>()

    init {
        (1..10).forEach {
            database.add(Customer(UUID.randomUUID().toString(), "Customer $it"))
        }
    }


    fun findAll() = database

    fun findOne(id: String) = database.find { it.id == id }!!

    fun create(customer: Customer): Customer =
        customer.copy(id = UUID.randomUUID().toString())
            .let {
                database.add(it)
                it
            }

    fun update(id: String, customer: Customer): Customer {
        val customerFound = database.find { it.id == id }!!
        val customerUpdated = customerFound.copy(name = customer.name)
        database[database.indexOf(customerFound)] = customerUpdated
        return customerUpdated
    }

    fun delete(id: String) {
        database.remove(database.find { it.id == id })
    }
}

