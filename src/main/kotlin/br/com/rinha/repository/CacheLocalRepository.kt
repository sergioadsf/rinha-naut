package br.com.rinha.repository

import br.com.rinha.entities.Pessoa
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.collections.HashMap

@Singleton
class CacheLocalRepository(
    private val objectMapper: ObjectMapper
) {

    companion object {
        val concurrentHashMap = HashMap<String, String>()
    }
    private val mutex = Mutex()
    suspend fun save(pessoa: Pessoa) = mutex.withLock {
        val pessoaStr = objectMapper.writeValueAsString(pessoa)
        concurrentHashMap[pessoa.id.toString()] = pessoaStr
        concurrentHashMap[pessoa.apelido!!] = pessoaStr
    }

    suspend fun getById(id: UUID) =
        concurrentHashMap[id.toString()]

    suspend fun getByApelido(apelido: String) =
        concurrentHashMap.contains(apelido)
}