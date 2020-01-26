package io.pivotal.shinyay.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(@Id @GeneratedValue var id: Int,
                  @Column(nullable = false, unique = true) var name: String,
                  @Column(nullable = false) var age: Int,
                  @Column(nullable = false) var gender: Gender) {
}