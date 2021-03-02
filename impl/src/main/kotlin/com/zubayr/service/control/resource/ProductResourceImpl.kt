package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.api.model.ProductDto
import com.zubayr.service.control.api.resource.ProductResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ProductResourceImpl: ProductResource {
    override fun geByName(name: String): ResponseEntity<ProductDto> {
        TODO("Not yet implemented")
    }

    override fun getByCipher(cipher: String): ResponseEntity<ProductDto> {
        TODO("Not yet implemented")
    }

    override fun add(dto: PlanDto): ResponseEntity<ProductDto> {
        TODO("Not yet implemented")
    }

    override fun put(dto: PlanDto): ResponseEntity<ProductDto> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID): ResponseEntity<Boolean> {
        TODO("Not yet implemented")
    }
}