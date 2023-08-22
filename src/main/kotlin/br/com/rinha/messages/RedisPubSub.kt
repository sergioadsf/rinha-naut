package br.com.rinha.messages

import br.com.rinha.entities.Pessoa
import br.com.rinha.repository.PessoaRepository
import com.fasterxml.jackson.databind.ObjectMapper
import io.lettuce.core.RedisClient
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking
import javax.annotation.PostConstruct

@Singleton
class RedisPubSub(
    private val redisClient: RedisClient,
    private val objectMapper: ObjectMapper,
    private val repository: PessoaRepository
) {
    private val pubSub = redisClient.connectPubSub()
    private val reactiveCmd = pubSub.reactive()

    companion object {
        const val CH_PESSOA = "CH-PESSOA"
    }

    fun send(pessoa: Pessoa) {
        redisClient.connectPubSub()
            .reactive().publish(CH_PESSOA, objectMapper.writeValueAsString(pessoa)).subscribe()
    }

    @PostConstruct
    fun init() {
        reactiveCmd.subscribe(CH_PESSOA).subscribe()
        reactiveCmd.observeChannels().doOnNext { message ->
            if (CH_PESSOA == message.channel) {
                runBlocking {
                    repository.save(objectMapper.readValue(message.message, Pessoa::class.java))
                }
            }
        }.subscribe()
    }
}