package org.example

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import org.hibernate.annotations.UuidGenerator.Style.AUTO
import java.util.*

@Entity
@Table(name = "DemoApp")
data class DemoSQL(

    @Column(name = "testMe", nullable = false, updatable = true)
    var test: String

) {

    @Id
    @Column(name = "uuid", nullable = false, updatable = false)
    @UuidGenerator(style = AUTO)
    @GeneratedValue
    private lateinit var uuid: UUID

}