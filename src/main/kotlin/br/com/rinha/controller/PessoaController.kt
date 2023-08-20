package br.com.rinha.controller

import br.com.rinha.entities.Pessoa
import br.com.rinha.repository.CacheRepository
import br.com.rinha.repository.PessoaQuery
import br.com.rinha.repository.PessoaRepository
import br.com.rinha.repository.Specifications
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import reactor.core.publisher.Flux
import java.net.URI
import java.util.*


@Controller("/pessoas")
class PessoaController(
    private val repository: PessoaRepository,
    private val cacheRepository: CacheRepository,
    private val pessoaQuery: PessoaQuery,
) {

    @Get
    suspend fun list(@QueryValue("t") term: String?): MutableHttpResponse<Flux<Pessoa?>?> {
        return if (term.isNullOrBlank() || term.isEmpty()) {
            HttpResponse.badRequest()
        } else {
//            val sql = "select * from pessoas where apelido like %$term% limit 5"
//            r2dbcOperations.withConnection{c, p -> {
//                val pub = c.createStatement(sql).execute()
//                pub.
//                return customers
//            }}
//            HttpResponse.ok(repository.findAll(Specifications.byTerm(term)))
            HttpResponse.ok(pessoaQuery.findByTerm(term))
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

