package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Gender
import io.pivotal.shinyay.entity.Person
import io.pivotal.shinyay.repository.PersonRepositoryDBInterface
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/db")
class PersonDBController(val repository: PersonRepositoryDBInterface) {

    @GetMapping
    fun findAll(): MutableIterable<Person> = repository.findAll()

    @GetMapping("/person/name/{firstname}")
    fun findByName(@PathVariable firstname: String) = repository.findByFirstname(firstname)

    @GetMapping("/person/{id}")
    fun findOne(@PathVariable id: Int) = repository.findById(id)

    private fun create(person: Person) = repository.save(person)

    @PostConstruct
    fun demoData() {
        create(Person(1, "Rei", "Ayanami", 14, Gender.FEMALE))
        create(Person(2, "Shinji", "Ikari", 14, Gender.MALE))
        create(Person(3, "Asuka Langley", "Soryu", 14, Gender.FEMALE))
        create(Person(4, "Torji", "Suzuhara", 14, Gender.MALE))
        create(Person(5, "Kaoru", "Nagisa", 14, Gender.MALE))
    }
}