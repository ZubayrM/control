package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Plan
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface PlanRepo: PagingAndSortingRepository<Plan, UUID> {
}