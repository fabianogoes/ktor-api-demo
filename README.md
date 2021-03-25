![Ktor Logo](ktor.png)
# Ktor API Demo

**Table of Content**

- [Goal](#goal)
- [Technologies](#technologies)
- [Challenge](#challenges)
- [Decisions](#decisions)

## Goal

To Learn as develop a Simple REST API using Kotlin with Ktor.

## Technologies

- [Kotlin][0]
- [Ktor][1]
- [Koin][2]
- [Gradle][3]
- [Netty][4]

## Challenges

- Never have any contact with [Ktor][1] before
- To use [Koin][2] to solve Dependency Injection

## Decisions 

- To use [Koin][2] to solve Dependency Injection because it looks well integrated with ktor, and it looks very simple.
- To use layers pattern based in [Clean Architecture][5] and [Hexagonal Architecture][6] (a.k.a. Ports and Adapters).
- I don't created a Domain layer because this project is only a CRUD, and I think at the moment it doesn't make sense. 

**Layers**

+ application
  + UseCases
  + Ports
  + Models
+ boundaries
  + routes
+ infrastructure
  + repositories
  + Adapters


[0]: https://kotlinlang.org/docs/home.html
[1]: https://ktor.io/docs/welcome.html
[2]: https://insert-koin.io/
[3]: https://gradle.org/
[4]: https://netty.io/
[5]: https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
[6]: https://alistair.cockburn.us/hexagonal-architecture/