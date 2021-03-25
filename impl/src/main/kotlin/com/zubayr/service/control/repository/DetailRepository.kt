package com.zubayr.service.control.repository

import com.zubayr.service.control.domain.model.Detail
import com.zubayr.service.control.domain.model.Enum.StageStatusEnum
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DetailRepository : PagingAndSortingRepository<Detail, UUID> {

    fun findByName(name: String): List<Detail>

    fun getById(id: UUID): Detail

    fun getAllByProductId(productId: UUID): List<Detail>

    fun countDetailByProductIdAndStage(productId: UUID, stage: StageStatusEnum): Long

    @Query("select * from detail where is_deleted = false and product_id = :productId and cipher = :cipher and stage = :stage ", nativeQuery = true)
    fun getByProductIdAndCipherAndStage(productId: UUID, cipher:String, stage: Int): List<Detail>


}