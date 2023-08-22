package br.com.rinha.repository

import br.com.rinha.entities.Pessoa
import br.com.rinha.utils.ListStringConverter
import io.micronaut.data.r2dbc.operations.R2dbcOperations
import io.r2dbc.spi.Connection
import io.r2dbc.spi.Row
import io.r2dbc.spi.RowMetadata
import jakarta.inject.Singleton
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate
import java.util.*
import java.util.function.BiFunction

@Singleton
class PessoaQuery(
    private val r2dbcOperations: R2dbcOperations
) {

    companion object {
        val MAPPING_FUNCTION: BiFunction<Row, RowMetadata, Pessoa> = BiFunction<Row, RowMetadata, Pessoa> { row, _ ->
            val id: String? = row.get("id", String::class.java)
            val nome: String? = row.get("nome", String::class.java)
            val apelido: String? = row.get("apelido", String::class.java)
            val nascimento: LocalDate = row.get("nascimento", LocalDate::class.java)
            val stack: String? = row.get("stack", String::class.java)
            Pessoa(UUID.fromString(id), nome, apelido, nascimento, stack?.split(ListStringConverter.SPLIT))
        }
    }

    suspend fun findByTerm(term: String): Flux<Pessoa?>? {
        val sql = "select * from pessoas where TERMO like '%$term%' limit 50"
        return Flux.from(
            r2dbcOperations.withConnection { connection: Connection ->
                Flux.from(
                    connection.createStatement(sql).execute()
                )
                    .flatMap { r -> r.map(MAPPING_FUNCTION) }
            })
    }

    suspend fun getById(id: UUID): Mono<Pessoa?>? {
        val sql = "select * from pessoas where id = '$id'"

        return Mono.from(
            r2dbcOperations.withConnection { connection: Connection ->
                Mono.from(
                    connection.createStatement(sql).execute()
                ).flatMap { r -> Mono.from(r.map(MAPPING_FUNCTION)) }
            })
    }

    suspend fun exists(apelido: String): Mono<Boolean> {
        val sql = "select * from pessoas where apelido = $apelido"
        return Mono.from(
            r2dbcOperations.withConnection { connection: Connection ->
                Mono.from(
                    connection.createStatement(sql).execute()
                )
                    .map { true }
            })
    }
}