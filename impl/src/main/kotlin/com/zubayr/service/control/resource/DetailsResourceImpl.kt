package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.api.model.DetailsStatusDto
import com.zubayr.service.control.api.resource.DetailsResource
import com.zubayr.service.control.mapper.DetailMapper
import com.zubayr.service.control.service.DetailService
import org.mapstruct.factory.Mappers
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import java.util.*

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class DetailsResourceImpl(
        private val detailService: DetailService
) : DetailsResource {

    private final val detailMapper: DetailMapper = Mappers.getMapper(DetailMapper::class.java)

    override fun getById(id: UUID) = ResponseEntity.ok(detailService.getById(id))


    override fun getStatusByProductId(id: UUID): ResponseEntity<DetailsStatusDto> {
        return ResponseEntity.ok(detailService.getStatusByProductId(id))
    }
}