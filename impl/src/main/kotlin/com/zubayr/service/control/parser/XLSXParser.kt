package com.zubayr.service.control.parser

import com.zubayr.service.control.domain.model.Detail
import com.zubayr.service.control.domain.model.Plan
import com.zubayr.service.control.domain.model.Product
import com.zubayr.service.control.repository.PlanRepository
import com.zubayr.service.control.repository.ProductRepository
import java.io.File
import java.io.FileInputStream
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.*
import kotlin.collections.ArrayList

@Component
@ConfigurationProperties(prefix = "control", ignoreUnknownFields = false)
class XLSXParser(
        private val productRepository: ProductRepository,
        private val planRepository: PlanRepository) {

    var redurants: List<String> = mutableListOf()
    var matcher:String = String()
    val month = "(январь|февраль|март|апрель|май|июнь|июль|август|сентябрь|октябрь|ноябрь|декабрь)"


    fun parse(path: String): List<Detail> {
        val workbook = XSSFWorkbook(FileInputStream(File(path)))
        val sheet = workbook.getSheetAt(0)

        val list = ArrayList<Detail>()

        var productName: String?
        var newProduct: Product? = null
        var savePlan: Plan? = null

        for (row in sheet){
            val cell0 = row.getCell(0)
            val cell1 = row.getCell(1)
            val cell4 = row.getCell(4)

            if((cell0 == null || cell0.toString() == "") && (cell1 != null && cell1.toString() != "") ){
                val value = cell1.toString()

                val regex = Regex("""на\s$month\s\d{4}г\.""")

                if (value.matches (regex)){

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
                    savePlan = planRepository.save(plan)
                }

            }

            else if (cell0 != null && cell0.toString() != "" ) {
                if ((cell1 == null || cell1.toString() == "")) {
                    productName = cell0.toString()

                    val split = productName.trim().split(" ")
                        .filter { redurants.contains(it).not() }
                        .filter { it.matches(Regex(matcher)).not() }

                    newProduct = Product(
                        cipher = split.last(),
                        name = split.dropLast(1).reduce {s1,s2-> "$s1 $s2"},
                        plan = savePlan
                    )
                    newProduct = productRepository.save(newProduct)
                }

                if (cell4 != null && cell4.toString() != "" ) {
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
                            println(row.getCell(0))
                        }
                    }
                }
            }
        }
        return list
    }
}