package br.com.rinha.controller

import br.com.rinha.entities.Pessoa
import br.com.rinha.repository.CacheRepository
import br.com.rinha.repository.PessoaRepository
import br.com.rinha.repository.Specifications
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import java.net.URI
import java.util.UUID

@Controller("/pessoas")
class PessoaController(
    private val repository: PessoaRepository,
    private val cacheRepository: CacheRepository
) {

    @Get
    suspend fun list(@QueryValue("t") term: String?): MutableHttpResponse<Flow<Pessoa?>?> {
        return if (term.isNullOrBlank() || term.isEmpty()) {
            HttpResponse.badRequest()
        } else {
            HttpResponse.ok(repository.findAll(Specifications.byTerm(term)))
        }
    }

    @Post
    suspend fun save(pessoa: Pessoa): MutableHttpResponse<Unit> {
        if (pessoa.apelido == null || pessoa.nome == null || cacheRepository.getByApelido(pessoa.apelido)) {
            return HttpResponse.unprocessableEntity()
        }
        return try {
            pessoa.id = UUID.randomUUID()
            cacheRepository.save(pessoa)
            coroutineScope {
                async { repository.save(pessoa) }
            }
            HttpResponse.created(URI("/pessoas/" + pessoa.id))
        } catch (e: Exception) {
            HttpResponse.unprocessableEntity()
        }
    }

    @Get("/{id}")
    suspend fun get(@PathVariable("id") id: UUID): Pessoa? = cacheRepository.getById(id)

    @Get("/contagem-pessoas")
    suspend fun count() = repository.count().toString()
}

