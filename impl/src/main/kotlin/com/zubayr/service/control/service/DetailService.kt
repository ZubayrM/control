package com.zubayr.service.control.service

import com.zubayr.service.control.api.model.detail.ListDetailDto
import com.zubayr.service.control.api.model.DetailDto
import com.zubayr.service.control.domain.model.Detail
import com.zubayr.service.control.domain.model.Plan
import com.zubayr.service.control.mapper.temporary.DetailConverter
import com.zubayr.service.control.parser.XLSXParser
import com.zubayr.service.control.repository.DetailRepo
import com.zubayr.service.control.repository.PlanRepo
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

@Service
class DetailService(
    private val detailRepo: DetailRepo,
    private val planRepo: PlanRepo,
    private val detailConverter: DetailConverter,
    private val parser: XLSXParser
    ) {
    val converter = com.zubayr.service.control.mapper.temporary.DetailConverter()

    private val path: String = "data.xlsx"

    fun getById(id: UUID): DetailDto {
        TODO("Not yet implemented")
    }

    fun getByCipher(cipher: String): DetailDto {
        TODO("Not yet implemented")
    }

    fun getByName(name: String): ArrayList<ListDetailDto> {
        val list = detailRepo.findByName(name)

        val listDto = list.map {o-> converter.toDto(o) }

        val responseList = ArrayList<ListDetailDto>()

        val groupBy = listDto.groupBy { detail -> detail.cipher }
        groupBy.forEach { (t, u) ->
            run {
                responseList.add(ListDetailDto(name = u[0].name, cipher = t, list = u))
            }
        }
        return responseList;
    }

    fun getByEmployee(id: UUID): List<DetailDto> {
        TODO("Not yet implemented")
    }

    fun getByProduct(id: UUID): List<DetailDto> {
        TODO("Not yet implemented")
    }

    fun getAllByPlan(id: UUID): List<DetailDto> {
        TODO("Not yet implemented")
    }

    fun add(dto: DetailDto): DetailDto {
        TODO("Not yet implemented")
    }

    fun addAll(file: MultipartFile): List<DetailDto> {
//        val localDate = LocalDate
//            .parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"))

//        val plan = planRepo.save(Plan(
//            startDate = localDate.withDayOfMonth(1),
//            endDate = localDate.withDayOfMonth(localDate.lengthOfMonth()))
//        )

        val writePath = Files.write(Path.of(path), file.bytes)
        val list: List<Detail> = parser.parse(writePath.toAbsolutePath().toString())
        val saveAll = detailRepo.saveAll(list)
        return saveAll.map{o-> detailConverter.toDto(o)}
    }

    fun put(dto: DetailDto): DetailDto {
        TODO("Not yet implemented")
    }

    fun delete(id: UUID): Boolean {
        TODO("Not yet implemented")
    }


}