package com.example

import com.example.application.CustomerUseCase
import com.example.application.CustomerUseCaseImpl
import com.example.application.port.CustomerPersistencePort
import com.example.infrastructure.CustomerRepositoryTemporaryAdapter
import com.example.routes.customerRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.core.context.startKoin
import org.koin.dsl.module


//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
fun main(args: Array<String>) {
    val koinModule = module {
        single<CustomerUseCase> { CustomerUseCaseImpl(get()) }
        single<CustomerPersistencePort> { CustomerRepositoryTemporaryAdapter() }
    }

    startKoin{
        modules(koinModule)
    }

    embeddedServer(Netty, commandLineEnvironment(args)).start()
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        customerRouting()
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

