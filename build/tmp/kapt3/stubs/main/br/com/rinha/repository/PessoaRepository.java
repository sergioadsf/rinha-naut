package br.com.rinha.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u0004J#\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lbr/com/rinha/repository/PessoaRepository;", "Lio/micronaut/data/repository/kotlin/CoroutineCrudRepository;", "Lbr/com/rinha/entities/Pessoa;", "Ljava/util/UUID;", "Lio/micronaut/data/repository/jpa/kotlin/CoroutineJpaSpecificationExecutor;", "byTerm", "", "term", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getById", "ids", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rinha-naut"})
@io.micronaut.data.r2dbc.annotation.R2dbcRepository(dialect = io.micronaut.data.model.query.builder.sql.Dialect.POSTGRES)
public abstract interface PessoaRepository extends io.micronaut.data.repository.kotlin.CoroutineCrudRepository<br.com.rinha.entities.Pessoa, java.util.UUID>, io.micronaut.data.repository.jpa.kotlin.CoroutineJpaSpecificationExecutor<br.com.rinha.entities.Pessoa> {
    
    @org.jetbrains.annotations.Nullable()
    @io.micronaut.data.annotation.Query(value = "SELECT * FROM Pessoas  WHERE id::uuid = :ids")
    public abstract java.lang.Object getById(@org.jetbrains.annotations.NotNull()
    java.util.UUID ids, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.rinha.entities.Pessoa> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @io.micronaut.data.annotation.Query(value = "SELECT p.* FROM Pessoas p WHERE p.apelido like \'%:term%\'", nativeQuery = true)
    public abstract java.lang.Object byTerm(@org.jetbrains.annotations.NotNull()
    java.lang.String term, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.rinha.entities.Pessoa>> continuation);
}