package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Person
import io.pivotal.shinyay.repository.PersonRepositoryDBInterface
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/db")
class PersonDBController(val repository: PersonRepositoryDBInterface) {

    @GetMapping
    fun findAll(): MutableIterable<Person> = repository.findAll()

    @GetMapping("/person/{name}")
    fun findByName(@PathVariable name: String) = repository.findByName(name)

    @GetMapping("/person/(id}")
    fun findOne(@PathVariable id: Int) = repository.findById(id)
}