package com.example.infrastructure

import com.example.application.port.CustomerPersistencePort
import com.example.domain.Customer
import java.util.*

class CustomerRepositoryTemporaryAdapter : CustomerPersistencePort {

    private val database = mutableListOf<Customer>()

    init {
        (1..10).forEach {
            database.add(Customer(UUID.randomUUID().toString(), "Customer $it"))
        }
    }


    override fun findAll() = database

    override fun findOne(id: String) = database.find { it.id == id }!!

    override fun create(customer: Customer): Customer =
        customer.copy(id = UUID.randomUUID().toString())
            .let {
                database.add(it)
                it
            }

    override fun update(id: String, customer: Customer): Customer {
        val customerFound = database.find { it.id == id }!!
        val customerUpdated = customerFound.copy(name = customer.name)
        database[database.indexOf(customerFound)] = customerUpdated
        return customerUpdated
    }

    override fun delete(id: String) {
        database.remove(database.find { it.id == id })
    }
}

