package com.zubayr.service.control.domain.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "plan")
class Plan (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: UUID,

        @Column(name = "start_date")
        val startDate: LocalDate,

        @Column(name = "end_date")
        val endDate: LocalDate,

        @Column(name = "real_end_date")
        val realEndDate: LocalDate,

        @OneToMany(
                mappedBy = "plan",
                fetch = FetchType.LAZY
        )
        val details: List<Detail> = emptyList()

)



