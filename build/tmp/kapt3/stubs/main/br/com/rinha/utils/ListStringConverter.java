package br.com.rinha.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\n"}, d2 = {"Lbr/com/rinha/utils/ListStringConverter;", "Ljakarta/persistence/AttributeConverter;", "", "", "()V", "convertToDatabaseColumn", "attribute", "convertToEntityAttribute", "dbData", "Companion", "rinha-naut"})
@jakarta.persistence.Converter()
public final class ListStringConverter implements jakarta.persistence.AttributeConverter<java.util.List<? extends java.lang.String>, java.lang.String> {
    @org.jetbrains.annotations.NotNull()
    public static final br.com.rinha.utils.ListStringConverter.Companion Companion = null;
    public static final char SPLIT = ';';
    
    public ListStringConverter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String convertToDatabaseColumn(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> attribute) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.List<java.lang.String> convertToEntityAttribute(@org.jetbrains.annotations.Nullable()
    java.lang.String dbData) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lbr/com/rinha/utils/ListStringConverter$Companion;", "", "()V", "SPLIT", "", "rinha-naut"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}