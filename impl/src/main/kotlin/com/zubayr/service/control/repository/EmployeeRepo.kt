package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Employee
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface EmployeeRepo: PagingAndSortingRepository<Employee, UUID> {
}