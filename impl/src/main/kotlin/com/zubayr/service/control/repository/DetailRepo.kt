package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Detail
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface DetailRepo: PagingAndSortingRepository<Detail, UUID> {
}