package io.pivotal.shinyay.repository

import io.pivotal.shinyay.entity.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepositoryDBInterface : CrudRepository<Person, Int> {
    fun findByName(name: String): List<Person>
}