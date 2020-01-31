package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Gender
import io.pivotal.shinyay.entity.Person
import io.pivotal.shinyay.repository.PersonRepositoryDBInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/db/person")
class PersonDBController(val repository: PersonRepositoryDBInterface) {

    @GetMapping
    fun findAll(): MutableIterable<Person> = repository.findAll()

    @GetMapping("/name/{firstname}")
    fun findByName(@PathVariable firstname: String) = repository.findByFirstname(firstname)

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Int) = repository.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody person: Person) = repository.save(person)

//    private fun create(person: Person) = repository.save(person)

    @PostConstruct
    fun demoData() {
        add(Person(1, "Rei", "Ayanami", 14, Gender.FEMALE))
        add(Person(2, "Shinji", "Ikari", 14, Gender.MALE))
        add(Person(3, "Asuka Langley", "Soryu", 14, Gender.FEMALE))
        add(Person(4, "Torji", "Suzuhara", 14, Gender.MALE))
        add(Person(5, "Kaoru", "Nagisa", 14, Gender.MALE))
    }
}