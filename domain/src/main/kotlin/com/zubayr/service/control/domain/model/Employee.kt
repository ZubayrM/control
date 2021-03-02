package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.ProfessionEnum
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee (
        @Id
        @GeneratedValue(generator = "uuid")
        val id: UUID? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "surname")
        val surname: String? = null,

        @Column(name = "date_of_birth")
        //@Temporal(TemporalType.DATE)
        val dataOfBirth: LocalDate? = null,

        @Column(name = "profession")
        val profession: ProfessionEnum? = null
)