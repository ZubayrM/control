package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.api.model.detail.ListDetailDto
import com.zubayr.service.control.api.model.detail.ProductAndListDetailDto
import com.zubayr.service.control.domain.model.Detail
import com.zubayr.service.control.mapper.DetailMapper
import com.zubayr.service.control.parser.XLSXParser
import com.zubayr.service.control.repository.DetailRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.collections.ArrayList

@Service
class DetailService(
        private val detailRepository: DetailRepository,
        private val parser: XLSXParser
    ) {

    private val detailMapper = Mappers.getMapper(DetailMapper::class.java)

    private val path: String = "data.xlsx"

    fun getById(id: UUID): DetailDto {
        TODO("Not yet implemented")
    }

    fun getByCipher(cipher: String): DetailDto {
        TODO("Not yet implemented")
    }

    fun getByName(name: String): ArrayList<ListDetailDto> {
        val list = detailRepository.findByName(name)
        return createListDetailDto(list);
    }

    fun getByEmployee(id: UUID): List<DetailDto> {
        TODO("Not yet implemented")
    }

    fun getByProduct(id: UUID): List<DetailDto> {
        TODO("Not yet implemented")
    }

    fun getAllByPlan(id: UUID): ArrayList<ProductAndListDetailDto> {
        val list = ArrayList<ProductAndListDetailDto>()
        return list
    }

    fun add(dto: DetailDto): DetailDto {
        TODO("Not yet implemented")
    }

    fun addAll(file: MultipartFile): List<DetailDto> {
        val writePath = Files.write(Path.of(path), file.bytes)
        val list: List<Detail> = parser.parse(writePath.toAbsolutePath().toString())
        val saveAll = detailRepository.saveAll(list)
        return saveAll.map{o-> detailMapper.convertToDto(o)}
    }

    fun put(dto: DetailDto): DetailDto {
        TODO("Not yet implemented")
    }

    fun delete(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    private fun createListDetailDto(list: List<Detail>): ArrayList<ListDetailDto> {
        val responseList: ArrayList<ListDetailDto> = ArrayList()
        val listDto = list.map { detail -> detailMapper.convertToDto(detail) }

        val groupBy = listDto.groupBy { detail -> detail.cipher }
        groupBy.forEach { (t, u) ->
            run {
                responseList.add(ListDetailDto(name = u[0].name, cipher = t, list = u))
            }
        }
        return responseList
    }

}