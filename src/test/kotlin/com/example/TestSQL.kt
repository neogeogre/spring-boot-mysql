package com.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.support.TransactionTemplate
import java.util.*

@SpringBootTest
class TestSQL(
    @Autowired var transactionTemplate: TransactionTemplate,
    @Autowired var repositorySQL: RepositorySQL
) {

  @Test
  fun `persistence mySql`() {
    val txt = "Hello world"
    val uuid = UUID.randomUUID()
    val demo = DemoSQL(uuid, txt)
    println("save $demo")
    transactionTemplate.execute { repositorySQL.save(demo) }
    transactionTemplate.execute { assertThat(repositorySQL.findAll().size).isGreaterThanOrEqualTo(1) }
  }

}
