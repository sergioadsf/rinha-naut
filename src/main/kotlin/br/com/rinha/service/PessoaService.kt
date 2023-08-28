package br.com.rinha.service

import br.com.rinha.entities.Pessoa
import br.com.rinha.repository.PessoaRepository
import io.micronaut.scheduling.annotation.Async
import jakarta.inject.Singleton

@Singleton
open class PessoaService(private val repository: PessoaRepository) {

    @Async
    open suspend fun saveAsync(pessoa: Pessoa){
        repository.save(pessoa)
    }
}