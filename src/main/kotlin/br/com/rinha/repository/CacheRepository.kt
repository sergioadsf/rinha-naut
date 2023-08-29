package br.com.rinha.repository

import br.com.rinha.controller.JobRinha
import br.com.rinha.entities.Pessoa
import com.fasterxml.jackson.databind.ObjectMapper
import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.coroutines
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.reactor.asFlux
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.util.*

@Singleton
@OptIn(ExperimentalLettuceCoroutinesApi::class)
class CacheRepository(
    private val objectMapper: ObjectMapper,
    redisConnection: StatefulRedisConnection<String, String>,
    private val repository: PessoaRepository,
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(CacheRepository::class.java)
    }
    private val connection = redisConnection.coroutines()

    suspend fun save(pessoa: Pessoa) {
        val str = objectMapper.writeValueAsString(pessoa)
        connection.set(pessoa.id!!.toString(), str)
        connection.set(pessoa.apelido!!, str)
    }

    suspend fun getById(id: UUID): Pessoa {
        val str = connection.get(id.toString())
        return objectMapper.readValue(str, Pessoa::class.java)
    }
    suspend fun getByApelido(apelido: String): Boolean{
        val l = connection.exists(apelido)
        return l != null && l > 0
    }

    suspend fun getAll(){
        val l = connection.hvals("*")
        LOG.info(l.toList().last())
        val v = l.map {
            val valueUUID = UUID.fromString(it)
            if(valueUUID.toString() == it) LOG.info(getById(valueUUID).toString())
        }.toList()
//        repository.saveAll(v.)

    }

}