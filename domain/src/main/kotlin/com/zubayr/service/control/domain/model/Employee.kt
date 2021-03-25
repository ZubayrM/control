package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.ProfessionEnum
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee (

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "surname")
        var surname: String? = null,

        @Column(name = "date_of_birth")
        var dataOfBirth: LocalDate? = null,

        @Column(name = "profession")
        var profession: ProfessionEnum? = null,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "employee")
        var infoOperations: MutableList<InfoOperation>? = mutableListOf()


) : BaseEntity()