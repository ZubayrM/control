package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.OperationDto
import com.zubayr.service.control.api.resource.OperationResource
import com.zubayr.service.control.service.OperationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class OperationResourceImpl(
        private val operationService: OperationService

) : OperationResource {


    override fun getOperationByDetailId(cipher: String): ResponseEntity<List<OperationDto>> {
        return ResponseEntity.ok(operationService.getOperationByDetailCipher(cipher))
    }
}