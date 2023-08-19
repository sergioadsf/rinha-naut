package br.com.rinha.entities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lbr/com/rinha/entities/Pessoa;", "", "id", "Ljava/util/UUID;", "nome", "", "apelido", "nascimento", "Ljava/time/LocalDate;", "stack", "", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;Ljava/util/List;)V", "getApelido", "()Ljava/lang/String;", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getNascimento", "()Ljava/time/LocalDate;", "getNome", "getStack", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "rinha-naut"})
@io.micronaut.data.annotation.MappedEntity(value = "pessoas")
@io.micronaut.core.annotation.Introspected()
public final class Pessoa {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    @org.jetbrains.annotations.Nullable()
    @io.micronaut.data.annotation.Id()
    private final java.lang.String nome = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String apelido = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate nascimento = null;
    @org.jetbrains.annotations.Nullable()
    @jakarta.persistence.Convert(converter = br.com.rinha.utils.ListStringConverter.class)
    private final java.util.List<java.lang.String> stack = null;
    
    public Pessoa(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, @org.jetbrains.annotations.Nullable()
    java.lang.String nome, @org.jetbrains.annotations.Nullable()
    java.lang.String apelido, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    java.time.LocalDate nascimento, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> stack) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNome() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getApelido() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getNascimento() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getStack() {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
}