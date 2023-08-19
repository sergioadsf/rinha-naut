package br.com.rinha.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ-\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00110\u00102\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u0016\u001a\u00020\u000bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lbr/com/rinha/controller/PessoaController;", "", "repository", "Lbr/com/rinha/repository/PessoaRepository;", "cacheRepository", "Lbr/com/rinha/repository/CacheRepository;", "(Lbr/com/rinha/repository/PessoaRepository;Lbr/com/rinha/repository/CacheRepository;)V", "count", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "Lbr/com/rinha/entities/Pessoa;", "id", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "list", "Lio/micronaut/http/MutableHttpResponse;", "Lkotlinx/coroutines/flow/Flow;", "term", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "pessoa", "(Lbr/com/rinha/entities/Pessoa;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rinha-naut"})
@io.micronaut.http.annotation.Controller(value = "/pessoas")
public final class PessoaController {
    private final br.com.rinha.repository.PessoaRepository repository = null;
    private final br.com.rinha.repository.CacheRepository cacheRepository = null;
    
    public PessoaController(@org.jetbrains.annotations.NotNull()
    br.com.rinha.repository.PessoaRepository repository, @org.jetbrains.annotations.NotNull()
    br.com.rinha.repository.CacheRepository cacheRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @io.micronaut.http.annotation.Get()
    public final java.lang.Object list(@org.jetbrains.annotations.Nullable()
    @io.micronaut.http.annotation.QueryValue(value = "t")
    java.lang.String term, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.micronaut.http.MutableHttpResponse<kotlinx.coroutines.flow.Flow<br.com.rinha.entities.Pessoa>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @io.micronaut.http.annotation.Post()
    public final java.lang.Object save(@org.jetbrains.annotations.NotNull()
    br.com.rinha.entities.Pessoa pessoa, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.micronaut.http.MutableHttpResponse<kotlin.Unit>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @io.micronaut.http.annotation.Get(value = "/{id}")
    public final java.lang.Object get(@org.jetbrains.annotations.NotNull()
    @io.micronaut.http.annotation.PathVariable(value = "id")
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.rinha.entities.Pessoa> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @io.micronaut.http.annotation.Get(value = "/contagem-pessoas")
    public final java.lang.Object count(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
}