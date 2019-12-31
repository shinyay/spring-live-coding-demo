package io.pivotal.shinyay.repository

import io.pivotal.shinyay.entity.Person
import org.springframework.stereotype.Repository

@Repository
class PersonRepository {

    val persons = mutableListOf<Person>()

    fun findAll() = persons

    fun findById(id: Int) = persons.singleOrNull{ it.id == id }

    fun save(person: Person): Person {
        person.id = (persons.maxBy { it.id }?.id ?: 0) + 1
        persons.add(person)
        return person
    }
}