package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.ProfessionEnum
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "employee")
class Employee (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: UUID,

        @Column(name = "name")
        val name: String,

        @Column(name = "surname")
        val surname: String,

        @Column(name = "date_of_birth")
        val dataOfBirth: LocalDate,

        @Column(name = "profession")
        val profession: ProfessionEnum



)