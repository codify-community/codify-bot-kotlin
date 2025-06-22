package io.github.codify.internal

import org.jetbrains.exposed.sql.Database

object DatabaseConfig {
    val db = Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver")

    fun connect() {
        println("Banco inicializado")
    }
}