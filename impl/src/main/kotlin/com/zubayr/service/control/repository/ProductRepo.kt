package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Product
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface ProductRepo: PagingAndSortingRepository<Product, UUID> {
}