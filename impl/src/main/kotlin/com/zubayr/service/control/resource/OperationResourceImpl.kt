package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.api.resource.OperationResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class OperationResourceImpl: OperationResource {
    override fun getByDetail(cipher: String): ResponseEntity<List<OperationDto>> {
        TODO("Not yet implemented")
    }

    override fun add(dto: OperationDto): ResponseEntity<OperationDto> {
        TODO("Not yet implemented")
    }

    override fun put(dto: OperationDto): ResponseEntity<OperationDto> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID): ResponseEntity<Boolean> {
        TODO("Not yet implemented")
    }
}