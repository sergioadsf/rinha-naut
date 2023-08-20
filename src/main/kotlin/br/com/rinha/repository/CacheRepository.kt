package br.com.rinha.repository

import br.com.rinha.entities.Pessoa
import com.fasterxml.jackson.databind.ObjectMapper
import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.coroutines
import jakarta.inject.Singleton
import java.util.UUID

@Singleton
@OptIn(ExperimentalLettuceCoroutinesApi::class)
class CacheRepository(
    private val objectMapper: ObjectMapper,
    redisConnection: StatefulRedisConnection<String, String>
) {
    private val connection = redisConnection.coroutines()

    suspend fun save(pessoa: Pessoa) {
        connection.set(pessoa.id!!.toString(), objectMapper.writeValueAsString(pessoa))
        connection.set(pessoa.apelido!!, objectMapper.writeValueAsString(pessoa))
    }

    suspend fun getById(id: UUID): Pessoa {
        val str = connection.get(id.toString())
        return objectMapper.readValue(str, Pessoa::class.java)
    }
    suspend fun getByApelido(apelido: String): Boolean{
        val l = connection.exists(apelido)
        return l != null && l > 0
    }

}