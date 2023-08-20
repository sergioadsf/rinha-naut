package br.com.rinha.repository

import br.com.rinha.entities.Pessoa
import io.micronaut.data.annotation.Query
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.repository.jpa.kotlin.CoroutineJpaSpecificationExecutor
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.*


@R2dbcRepository(dialect = Dialect.POSTGRES)
interface PessoaRepository : CoroutineCrudRepository<Pessoa, UUID>,
    CoroutineJpaSpecificationExecutor<Pessoa> {
    @Query("SELECT * FROM Pessoas  WHERE id::uuid = :ids")
    suspend fun getById(ids: UUID): Pessoa?
}

