package com.example.application

import com.example.application.port.CustomerPersistencePort
import com.example.domain.Customer

interface CustomerUseCase {

    fun findAll(): List<Customer>
    fun findOne(id: String): Customer
    fun create(customer: Customer): Customer
    fun update(id: String, customer: Customer): Customer
    fun delete(id: String)

}

class CustomerUseCaseImpl(private val repository: CustomerPersistencePort) : CustomerUseCase {

    override fun findAll(): List<Customer> = repository.findAll()

    override fun findOne(id: String): Customer = repository.findOne(id)

    override fun create(customer: Customer): Customer = repository.create(customer)

    override fun update(id: String, customer: Customer): Customer = repository.update(id, customer)

    override fun delete(id: String) {
        repository.delete(id)
    }
}