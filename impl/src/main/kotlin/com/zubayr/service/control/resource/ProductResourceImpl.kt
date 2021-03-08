package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.PlanDto
import com.zubayr.service.control.api.model.ProductDto
import com.zubayr.service.control.api.resource.ProductResource
import com.zubayr.service.control.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import java.util.*
@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class ProductResourceImpl(
        private val productService: ProductService
): ProductResource {

    override fun geById(id: UUID): ResponseEntity<ProductDto> = ResponseEntity.ok().body(productService.getById(id))


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