package br.com.rinha.repository

import br.com.rinha.entities.Pessoa
import io.micronaut.data.repository.jpa.criteria.QuerySpecification


object Specifications {

    fun byTerm(term: String): QuerySpecification<Pessoa> {
        return QuerySpecification<Pessoa> { root, q, criteriaBuilder ->
            criteriaBuilder.or(
                criteriaBuilder.like(root.get("nome"), "%$term%"),
                criteriaBuilder.like(root.get("apelido"), "%$term%"),
                criteriaBuilder.like(root.get("stack"), "%$term%")
            )
        }
    }
}