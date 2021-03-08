package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.InfoOperation
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface InfoOperationRepository: PagingAndSortingRepository<InfoOperation, UUID> {
}