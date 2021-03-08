package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Plan
import com.zubayr.service.control.domain.model.Product
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository: PagingAndSortingRepository<Product, UUID> {

    fun getById(id: UUID): Product?
}