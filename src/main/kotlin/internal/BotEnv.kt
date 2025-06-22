package io.github.codify.internal

import io.github.cdimascio.dotenv.Dotenv

object BotEnv {
    private val env = Dotenv.load()
    const val PREFIX = "!"
    val token = env.get("TOKEN")
}