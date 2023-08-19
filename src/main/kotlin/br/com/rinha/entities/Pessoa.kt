package br.com.rinha.entities

import br.com.rinha.utils.ListStringConverter
import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import jakarta.persistence.Convert
import java.time.LocalDate
import java.util.*

@Introspected
@MappedEntity(value = "pessoas")
class Pessoa(
    var id: UUID?,
    @field:Id
    val nome: String?,
    val apelido: String?,
    @JsonFormat(pattern="yyyy-MM-dd")
    val nascimento: LocalDate,
    @Convert(converter = ListStringConverter::class)
    val stack: List<String>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pessoa

        if (nome != other.nome) return false
        if (apelido != other.apelido) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + apelido.hashCode()
        return result
    }
}
