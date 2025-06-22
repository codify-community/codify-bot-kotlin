package io.github.codify.command.prefix

import io.github.codify.model.User
import io.github.codify.model.UserEntity
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

class RegisterCommand : IPrefix {
    override fun respondTo(event: MessageReceivedEvent) {
        transaction {
            addLogger(StdOutSqlLogger)
            UserEntity.new {
                discordId = event.member?.id ?: throw IllegalArgumentException()
            }
        }
        event.channel.sendMessage("teste").queue()
    }
}