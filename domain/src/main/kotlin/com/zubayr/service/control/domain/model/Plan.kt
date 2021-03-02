package com.zubayr.service.control.domain.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "plan")
data class Plan(

    @Id
        @GeneratedValue(generator = "uuid")
        @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "start_date")
        //@Temporal(TemporalType.DATE)
    val startDate: LocalDate? = null,

    @Column(name = "end_date")
        //@Temporal(TemporalType.DATE)
    val endDate: LocalDate? = null,

    @Column(name = "real_end_date")
        //@Temporal(TemporalType.DATE)
    val realEndDate: LocalDate? = null

//        @OneToMany(
//                mappedBy = "plan",
//                fetch = FetchType.LAZY
//        )
//        val details: List<Detail>? = ArrayList()
)



