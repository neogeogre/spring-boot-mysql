package com.example

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import org.hibernate.annotations.UuidGenerator.Style.TIME
import java.util.*

@Entity
@Table(name = "demo")
data class DemoSQL(


    @Column(name = "test_me", nullable = false, updatable = true)
    var test: String

) {

    @Id
    @Column(name = "uuid", nullable = false, updatable = false)
    @UuidGenerator(style = TIME)
    @GeneratedValue
    private lateinit var uuid: UUID

}