package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Plan
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface PlanRepository: PagingAndSortingRepository<Plan, UUID> {

    fun findByStartDate(date: LocalDate): Plan?

    fun getById(id: UUID): Plan?

}