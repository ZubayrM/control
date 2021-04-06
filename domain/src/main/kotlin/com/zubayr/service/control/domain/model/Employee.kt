package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.ProfessionEnum
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee(

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "surname")
        var surname: String? = null,

        @Column(name = "date_of_birth")
        var dataOfBirth: LocalDate? = null,

        @Column(name = "profession")
        var profession: ProfessionEnum? = null,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "employee")
        var infoOperations: MutableList<InfoOperation>? = mutableListOf(),

        @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
        @JoinTable(name = "employee_operation",
                joinColumns = [JoinColumn(name = "employee_id")],
                inverseJoinColumns = [JoinColumn(name = "operation_id")]
        )
        var operations: MutableSet<Operation> = mutableSetOf()

) : BaseEntity() {

    fun addOperation(operation: Operation) {
        operations.add(operation)
        operation.employees.add(this)
    }

    fun deleteOperation(operation: Operation){
        operations.remove(operation)
        operation.employees.remove(this)
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}