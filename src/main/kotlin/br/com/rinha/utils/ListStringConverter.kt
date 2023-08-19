package br.com.rinha.utils

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class ListStringConverter: AttributeConverter<List<String>?, String?> {
    companion object {
        const val SPLIT = ';'
    }

    override fun convertToDatabaseColumn(attribute: List<String>?): String? {
        return attribute.toString()
    }

    override fun convertToEntityAttribute(dbData: String?): List<String>? {
        return dbData?.split(SPLIT)
    }
}