package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Operation
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface OperationRepo: PagingAndSortingRepository<Operation, UUID> {
}