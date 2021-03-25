package com.example.services

import com.example.models.Customer
import com.example.repository.CustomerRepository

interface CustomerService {

    fun findAll(): List<Customer>
    fun findOne(id: String): Customer
    fun create(customer: Customer): Customer
    fun update(id: String, customer: Customer): Customer
    fun delete(id: String)

}

class CustomerServiceImpl(private val repository: CustomerRepository) : CustomerService {

    override fun findAll(): List<Customer> = repository.findAll()

    override fun findOne(id: String): Customer = repository.findOne(id)

    override fun create(customer: Customer): Customer = repository.create(customer)

    override fun update(id: String, customer: Customer): Customer = repository.update(id, customer)

    override fun delete(id: String) {
        repository.delete(id)
    }
}