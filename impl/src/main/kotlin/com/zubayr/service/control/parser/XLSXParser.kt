package com.zubayr.service.control.parser

import com.zubayr.service.control.domain.model.Detail
import com.zubayr.service.control.domain.model.Plan
import com.zubayr.service.control.domain.model.Product
import com.zubayr.service.control.repository.DetailRepository
import com.zubayr.service.control.repository.PlanRepository
import com.zubayr.service.control.repository.ProductRepository
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import java.io.File
import java.io.FileInputStream
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.*
import kotlin.collections.ArrayList

@Component
@ConfigurationProperties(prefix = "control", ignoreUnknownFields = true)
class XLSXParser(
    private val productRepository: ProductRepository,
    private val planRepository: PlanRepository,
    private val detailRepository: DetailRepository

    ) {

    private var redurants: List<String> = mutableListOf()
    private var matcher:String = String()
    private val month = "(январь|февраль|март|апрель|май|июнь|июль|август|сентябрь|октябрь|ноябрь|декабрь)"
    private val list = ArrayList<Detail>()

    @Deprecated("method sluggish")
    fun parse(path: String): List<Detail> {
        list.clear()
        val workbook = XSSFWorkbook(FileInputStream(File(path)))
        return parseWorkbook(workbook)
    }

    fun parse(file: MultipartFile): List<Detail> {
        list.clear()
        val workbook = XSSFWorkbook(file.inputStream)
        return detailRepository.saveAll(parseWorkbook(workbook)).toList()
    }

    private fun parseWorkbook(workbook: XSSFWorkbook): ArrayList<Detail> {
        val sheet = workbook.getSheetAt(0)
        var newProduct: Product? = null
        var savePlan: Plan? = null

        for (row in sheet) {
            val cell0 = row.getCell(0)
            val cell1 = row.getCell(1)
            val cell4 = row.getCell(4)

            if ((cell0 == null || cell0.toString() == "") && (cell1 != null && cell1.toString() != "")) {
                savePlan = addPlan(cell1, savePlan)
            } else if (cell0 != null && cell0.toString() != "") {
                if ((cell1 == null || cell1.toString() == "")) {
                    newProduct = addProduct(cell0, savePlan)
                }

                if (cell4 != null && cell4.toString() != "") {
                    addDetail(cell4, row, newProduct)
                }
            }
        }
        return list
    }

    private fun addDetail(
        cell4: Cell,
        row: Row,
        newProduct: Product?
    ) {
        cell4.toString().toBigDecimalOrNull()?.let {
            for (i in 0 until it.intValueExact()) {
                list.add(
                    Detail(
                        cipher = row.getCell(0).toString(),
                        name = row.getCell(1).toString(),
                        productId = newProduct?.id,
                        route = row.getCell(2).toString(),
                        material = row.getCell(3).toString(),
                        fullTimeCreated = row.getCell(5).toString().replace(",", ".").toBigDecimal()
                    )
                )
            }
        }
    }

    private fun addProduct(
        cell0: Cell,
        savePlan: Plan?
    ): Product? {
        var productName = cell0.toString()
        var newProduct: Product


        val split = productName.trim().split(" ")
            .filter { redurants.contains(it).not() }
            .filter { it.matches(Regex(matcher)).not() }

        newProduct = Product(
            cipher = split.last(),
            name = split.dropLast(1).reduce { s1, s2 -> "$s1 $s2" },
            plan = savePlan
        )
        return productRepository.save(newProduct)
    }

    private fun addPlan(
        cell1: Cell,
        savePlan: Plan?
    ): Plan? {
        var savePlan1 = savePlan
        val value = cell1.toString()

        val regex = Regex("""на\s$month\s\d{4}г\.""")

        if (value.matches(regex)) {

            val dataFormat = DateFormatSymbols.getInstance(Locale("ru"))
            dataFormat.months = month
                .replace("(", "")
                .replace(")", "")
                .split("|")
                .toTypedArray()


            val dataFormatter = SimpleDateFormat("'на' MMMM yyyy'г.'")
            dataFormatter.dateFormatSymbols = dataFormat


            val localDate = dataFormatter.parse(value)
            val startDate = LocalDate.from(localDate.toInstant().atZone(ZoneId.systemDefault()))
            val plan = Plan(startDate = startDate)
            savePlan1 = planRepository.save(plan)
        }
        return savePlan1
    }
}