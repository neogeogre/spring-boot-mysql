package com.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.support.TransactionTemplate

@SpringBootTest
class TestSQL {

    @Autowired
    lateinit var transactionTemplate: TransactionTemplate

    @Autowired
    lateinit var repositorySQL: RepositorySQL

    @Test
    fun `persistence mySql`() {
        val txt = "Hello world"
        val demo = DemoSQL(txt)
        println("save $demo ...")
        transactionTemplate.execute { repositorySQL.save(demo) }
        transactionTemplate.execute {
            val objs = repositorySQL.findAll()
            assertThat(objs.size).isGreaterThanOrEqualTo(1)
            assertThat(objs[0]).usingRecursiveAssertion().isEqualTo(demo)
        }
    }

}
