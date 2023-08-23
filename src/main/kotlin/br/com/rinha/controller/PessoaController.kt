package br.com.rinha.controller

import br.com.rinha.entities.Pessoa
import br.com.rinha.repository.*
import br.com.rinha.service.PessoaService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import reactor.core.publisher.Flux
import java.net.URI
import java.util.*


@Controller("/pessoas")
class PessoaController(
    private val repository: PessoaRepository,
    private val pessoaQuery: PessoaQuery,
    private val pessoaService: PessoaService,
    private val cacheLocalRepository: CacheLocalRepository,
) {

    @Get
    suspend fun list(@QueryValue("t") term: String?): MutableHttpResponse<Flux<Pessoa?>?> {
        return if (term.isNullOrBlank() || term.isEmpty()) {
            HttpResponse.badRequest()
        } else {
            HttpResponse.ok(pessoaQuery.findByTerm(term))
        }
    }

    @Post
    suspend fun save(pessoa: Pessoa): MutableHttpResponse<Unit> {

        if (pessoa.apelido.isNullOrEmpty() || pessoa.apelido.isEmpty() || pessoa.apelido.length > 32
            || pessoa.nome.isNullOrEmpty() || pessoa.nome.isEmpty() || pessoa.nome.length > 100
            || cacheLocalRepository.getByApelido(pessoa.apelido)
        ) {
            return HttpResponse.unprocessableEntity()
        }
        return try {
            pessoa.id = UUID.randomUUID()
            cacheLocalRepository.save(pessoa)
            pessoaService.saveAsync(pessoa)
            HttpResponse.created(URI("/pessoas/" + pessoa.id))
        } catch (e: Exception) {
            HttpResponse.unprocessableEntity()
        }
    }

    @Get("/{id}")
    suspend fun get(@PathVariable("id") id: UUID) =
        cacheLocalRepository.getById(id) ?:
        pessoaQuery.getById(id)

    @Get("/contagem-pessoas")
    suspend fun count() = repository.count().toString()

}

