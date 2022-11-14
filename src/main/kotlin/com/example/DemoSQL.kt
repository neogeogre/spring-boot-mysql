package com.example

import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "demo")
data class DemoSQL(

    @Id
    @Type(type = "uuid-char")
    @Column(name = "uuid", nullable = false)
    var uuid: UUID,

    @Column(name = "test", nullable = false)
    var test: String

)
