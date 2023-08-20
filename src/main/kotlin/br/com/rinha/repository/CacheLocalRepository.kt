package br.com.rinha.repository

import br.com.rinha.entities.Pessoa
import com.fasterxml.jackson.databind.ObjectMapper
import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.coroutines
import jakarta.inject.Singleton
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@Singleton
class CacheLocalRepository {
    companion object{
        val map: ConcurrentHashMap<String, Pessoa> = ConcurrentHashMap();
    }

    suspend fun save(pessoa: Pessoa){
        map[pessoa.id!!.toString()] = pessoa
        map[pessoa.apelido!!] = pessoa
    }

    suspend fun getById(id: UUID): Pessoa? {
        return map[id.toString()]
    }

    suspend fun getByApelido(apelido: String): Boolean{
        return map.contains(apelido)
    }
}