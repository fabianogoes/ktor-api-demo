package com.example.application.port

import com.example.domain.Customer

interface CustomerPersistencePort {
    fun findAll(): List<Customer>
    fun findOne(id: String): Customer
    fun create(customer: Customer): Customer
    fun update(id: String, customer: Customer): Customer
    fun delete(id: String)
}