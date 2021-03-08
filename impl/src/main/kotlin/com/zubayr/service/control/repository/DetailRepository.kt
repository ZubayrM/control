package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Detail
import com.zubayr.service.control.domain.model.Plan
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DetailRepository: PagingAndSortingRepository<Detail, UUID> {

    fun findByName(name: String): List<Detail>

    fun getAllByProductId(productId: UUID): List<Detail>

}