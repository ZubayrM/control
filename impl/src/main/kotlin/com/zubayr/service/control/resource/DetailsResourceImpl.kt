package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.detail.ListDetailDto
import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.api.resource.DetailsResource
import com.zubayr.service.control.repository.DetailRepo
import com.zubayr.service.control.service.DetailService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
class DetailsResourceImpl(
        private val detailRepo: DetailRepo,
        private val detailService: DetailService
): DetailsResource {

    //private final val converter: DetailConverter = Mappers.getMapper(DetailConverter::class.java)


    override fun getById(id: UUID): ResponseEntity<DetailDto> {
        val responseEntity = ResponseEntity.ok().header("Access-Control-Allow-Origin", "*")
        val converter = com.zubayr.service.control.mapper.temporary.DetailConverter()

        return  responseEntity.body(converter.toDto(detailRepo.findById(id).orElseThrow()))
    }

    override fun getByCipher(cipher: String): ResponseEntity<DetailDto> {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): ResponseEntity<ArrayList<ListDetailDto>> {
        val responseEntity = ResponseEntity.ok().header("Access-Control-Allow-Origin", "http://localhost:3000")
        val byName = detailService.getByName(name)
        return responseEntity.body(byName)
    }

    override fun getByEmployee(id: UUID): ResponseEntity<List<DetailDto>> {
        TODO("Not yet implemented")
    }

    override fun getByProduct(id: UUID): ResponseEntity<List<DetailDto>> {
        TODO("Not yet implemented")
    }

    override fun getAllByPlan(id: UUID): ResponseEntity<List<DetailDto>> {
        TODO("Not yet implemented")
    }

    override fun add(dto: DetailDto): ResponseEntity<DetailDto> {

        val converter = com.zubayr.service.control.mapper.temporary.DetailConverter()
        return ResponseEntity.ok(converter.toDto(detailRepo.save(converter.toModel(dto))))

//        val converter: DetailConverter = Mappers.getMapper(DetailConverter::class.java)
//        val result = converter.convertToDto(detailRepo.save(converter.convertToModel(dto)))
//        return ResponseEntity.ok(result)
    }

    override fun addAll(file: MultipartFile): ResponseEntity<List<DetailDto>> {
        return ResponseEntity.ok(detailService.addAll(file))
    }

    override fun put(dto: DetailDto): ResponseEntity<DetailDto> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID): ResponseEntity<Boolean> {
        TODO("Not yet implemented")
    }
}