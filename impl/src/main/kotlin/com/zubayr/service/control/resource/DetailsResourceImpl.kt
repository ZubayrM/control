package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.api.model.detail.ListDetailDto
import com.zubayr.service.control.api.model.detail.ProductAndListDetailDto
import com.zubayr.service.control.api.resource.DetailsResource
import com.zubayr.service.control.mapper.DetailMapper
import com.zubayr.service.control.repository.DetailRepository
import com.zubayr.service.control.service.DetailService
import org.mapstruct.factory.Mappers
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class DetailsResourceImpl(
        private val detailRepository: DetailRepository,
        private val detailService: DetailService
): DetailsResource {

    private final val detailMapper: DetailMapper = Mappers.getMapper(DetailMapper::class.java)

    override fun getById(id: UUID): ResponseEntity<DetailDto> {
        val responseEntity = ResponseEntity.ok().header("Access-Control-Allow-Origin", "*")
        return  responseEntity.body(detailMapper.convertToDto(detailRepository.findById(id).orElseThrow()))
    }

    override fun getByCipher(cipher: String): ResponseEntity<DetailDto> {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): ResponseEntity<ArrayList<ListDetailDto>> {
        val byName = detailService.getByName(name)
        return ResponseEntity.ok(byName)
    }

    override fun getByEmployee(id: UUID): ResponseEntity<List<DetailDto>> {
        TODO("Not yet implemented")
    }

    override fun getByProduct(id: UUID): ResponseEntity<List<DetailDto>> {
        TODO("Not yet implemented")
    }

    override fun getAllByPlan(id: UUID): ResponseEntity<List<ProductAndListDetailDto>> {
        return ResponseEntity.ok(detailService.getAllByPlan(id))
    }

    override fun add(dto: DetailDto): ResponseEntity<DetailDto> {

        return ResponseEntity.ok(detailMapper.convertToDto(detailRepository.save(detailMapper.convertToEntity(dto))))

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