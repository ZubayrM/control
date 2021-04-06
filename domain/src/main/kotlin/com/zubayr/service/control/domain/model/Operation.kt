package com.zubayr.service.control.domain.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "operation")
data class Operation (

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "serial_number")
        var serialNumber: Int? = null,

        @Column(name = "serial_number_by_operation")
        var serialNumberByOperation: Int? = null,

        @Column(name = "cipher_detail")
        var cipherDetail: String? = null,

        @Column(name = "time_in_hours")
        var time_in_hours: BigDecimal? = null,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "operation")
        var infoOperations: MutableList<InfoOperation>? = mutableListOf(),

        @ManyToMany(mappedBy = "operations", fetch = FetchType.EAGER)
        var employees: MutableSet<Employee> = mutableSetOf()

) : BaseEntity(){

        override fun equals(other: Any?): Boolean {
                return super.equals(other)
        }

        override fun hashCode(): Int {
                return super.hashCode()
        }
}