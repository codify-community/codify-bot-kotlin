package io.github.codify.model

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.SchemaUtils

object User : LongIdTable("user") {
    val discordId = varchar("discordId",20)

    init {
        SchemaUtils.create(this)
    }
}

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(User)

    var discordId by User.discordId
}