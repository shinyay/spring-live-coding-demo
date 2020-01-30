package io.pivotal.shinyay.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(@Id @GeneratedValue var id: Int,
                  @Column(nullable = false, unique = false) var firstname: String,
                  @Column(nullable = false, unique = false) var lastname: String,
                  @Column(nullable = false) var age: Int,
                  @Column(nullable = false) var gender: Gender) {
}