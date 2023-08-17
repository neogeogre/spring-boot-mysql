package org.example

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RepositorySQL : JpaRepository<DemoSQL, UUID>