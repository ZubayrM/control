package com.zubayr.service.control.domain.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "plan")
data class Plan(

    @Column(name = "start_date")
        //@Temporal(TemporalType.DATE)
    var startDate: LocalDate? = null,

    @Column(name = "end_date")
        //@Temporal(TemporalType.DATE)
    var endDate: LocalDate? = null,

    @Column(name = "real_end_date")
        //@Temporal(TemporalType.DATE)
    var realEndDate: LocalDate? = null,

    @OneToMany(mappedBy = "plan", fetch = FetchType.EAGER)
    var products: List<Product> = listOf()

): BaseEntity()



