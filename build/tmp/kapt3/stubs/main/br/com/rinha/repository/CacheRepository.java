package br.com.rinha.repository;

import java.lang.System;

@kotlin.OptIn(markerClass = {io.lettuce.core.ExperimentalLettuceCoroutinesApi.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lbr/com/rinha/repository/CacheRepository;", "", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "redisConnection", "Lio/lettuce/core/api/StatefulRedisConnection;", "", "(Lcom/fasterxml/jackson/databind/ObjectMapper;Lio/lettuce/core/api/StatefulRedisConnection;)V", "connection", "Lio/lettuce/core/api/coroutines/RedisCoroutinesCommands;", "getByApelido", "", "apelido", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getById", "Lbr/com/rinha/entities/Pessoa;", "id", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "pessoa", "(Lbr/com/rinha/entities/Pessoa;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rinha-naut"})
@jakarta.inject.Singleton()
public final class CacheRepository {
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper = null;
    private final io.lettuce.core.api.StatefulRedisConnection<java.lang.String, java.lang.String> redisConnection = null;
    private final io.lettuce.core.api.coroutines.RedisCoroutinesCommands<java.lang.String, java.lang.String> connection = null;
    
    public CacheRepository(@org.jetbrains.annotations.NotNull()
    com.fasterxml.jackson.databind.ObjectMapper objectMapper, @org.jetbrains.annotations.NotNull()
    io.lettuce.core.api.StatefulRedisConnection<java.lang.String, java.lang.String> redisConnection) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object save(@org.jetbrains.annotations.NotNull()
    br.com.rinha.entities.Pessoa pessoa, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getById(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.rinha.entities.Pessoa> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getByApelido(@org.jetbrains.annotations.NotNull()
    java.lang.String apelido, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}