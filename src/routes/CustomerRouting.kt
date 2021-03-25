package com.example.routes

import com.example.models.Customer
import com.example.services.CustomerService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Routing.customerRouting() {

    val service: CustomerService by inject()

    route("/customers") {

        get {
            call.respond(service.findAll())
        }

        get("/{id}") {
            val id: String = call.parameters["id"].toString()
            call.respond(service.findOne(id))
        }

        post {
            val customer = call.receive<Customer>()
            call.respond(HttpStatusCode.Created, service.create(customer))
        }

        put("/{id}") {
            val id = call.parameters["id"].toString()
            val customer = call.receive<Customer>()
            call.respond(service.update(id, customer))
        }

        delete("/{id}") {
            val id = call.parameters["id"].toString()
            service.delete(id)
            call.respond(HttpStatusCode.NoContent)
        }

    }
}