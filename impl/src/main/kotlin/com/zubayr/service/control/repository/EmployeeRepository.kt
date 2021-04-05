package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Employee
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EmployeeRepository: PagingAndSortingRepository<Employee, UUID> {

    fun getById(employeeId: UUID): Employee

    //TODO Добавить в имплоях данные по операции
//    fun getAllByInfoOperations()
}