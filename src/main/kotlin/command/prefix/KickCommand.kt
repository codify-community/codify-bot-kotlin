package io.github.codify.command.prefix

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.entities.UserSnowflake
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.exceptions.HierarchyException

object KickCommand : IPrefixCommand {
    override fun response(event: MessageReceivedEvent) {
        val member = event.member
        val msg = event.message.contentRaw
        val args = msg.split(" ")

        if (!member!!.hasPermission(Permission.KICK_MEMBERS)) {
            val failEmbed = EmbedBuilder()
                .setTitle("Não foi possível executar essa ação")
                .setDescription("O usuário **${member.nickname ?: member.effectiveName}** não possui permissão para executar essa ação")
                .setColor(16530965)
                .setFooter("Comando executado por ${member.nickname ?: member.effectiveName}", member.avatarUrl)
                .build()

            event.channel.sendMessageEmbeds(failEmbed).queue()

            return
        }

        if (args.size < 2) {
            val usageEmbed = EmbedBuilder()
                .setTitle("Uso incorreto do comando")
                .setDescription("Por favor, use: `!kick <ID_do_usuário> [razão: opcional]`")
                .setColor(16530965)
                .setFooter("Comando executado por ${member.nickname ?: member.effectiveName}", member.user.avatarUrl)
                .build()
            event.channel.sendMessageEmbeds(usageEmbed).queue()
            return
        }

        val targetUserId = args[1]
            .replace("<@", "")
            .replace(">", "")
            .replace("!", "")

        var reason = "Motivo não especificado"

        if (args.size > 2) {
            reason = args.subList(2, args.size).joinToString(" ")
        }

        try {
            event.guild.kick(UserSnowflake.fromId(targetUserId))
                .reason(reason)
                .queue({
                    val sucessEmbed = EmbedBuilder()
                        .setTitle("Expulsão realizada! ✔")
                        .addField(MessageEmbed.Field("🔰 Staff", member.nickname ?: member.effectiveName, true))
                        .addField(MessageEmbed.Field("Usuário punido", "<@$targetUserId>", true))
                        .addField(MessageEmbed.Field("Motivo", reason, false))
                        .setColor(65280)
                        .setFooter("Comando executado por ${member.effectiveName}", event.member?.user?.avatarUrl)
                        .build()

                    event.channel.sendMessageEmbeds(sucessEmbed).queue()
                })
        } catch (e: HierarchyException) {
            val hierarchyEmbed = EmbedBuilder()
                .setTitle("Erro ao executar a ação")
                .setDescription("Não é possível expulsar alguém do mesmo cargo ou superior ao meu")
                .setColor(16530965)
                .setFooter("Comando executado por ${member.effectiveName}", event.member?.user?.avatarUrl)
                .build()

            event.channel.sendMessageEmbeds(hierarchyEmbed).queue()
        }
    }
}
