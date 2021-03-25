package com.example.routes

import com.example.application.CustomerUseCase
import com.example.domain.Customer
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Routing.customerRouting() {

    val useCase: CustomerUseCase by inject()

    route("/customers") {

        get {
            call.respond(useCase.findAll())
        }

        get("/{id}") {
            val id: String = call.parameters["id"].toString()
            call.respond(useCase.findOne(id))
        }

        post {
            val customer = call.receive<Customer>()
            call.respond(HttpStatusCode.Created, useCase.create(customer))
        }

        put("/{id}") {
            val id = call.parameters["id"].toString()
            val customer = call.receive<Customer>()
            call.respond(useCase.update(id, customer))
        }

        delete("/{id}") {
            val id = call.parameters["id"].toString()
            useCase.delete(id)
            call.respond(HttpStatusCode.NoContent)
        }

    }
}