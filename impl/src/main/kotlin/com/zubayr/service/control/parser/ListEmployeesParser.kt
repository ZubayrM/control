package com.zubayr.service.control.parser

import com.zubayr.service.control.domain.model.Employee
import com.zubayr.service.control.domain.model.Enum.ProfessionEnum
import com.zubayr.service.control.repository.EmployeeRepository
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class ListEmployeesParser(
        private val employeeRepository: EmployeeRepository
) {
    private

    fun  parse(file: MultipartFile): List<Employee>{
        val workbook = XSSFWorkbook(file.inputStream)
        return employeeRepository.saveAll(parseWorkbook(workbook)).toList()

    }

    private fun parseWorkbook(workbook: XSSFWorkbook): ArrayList<Employee> {
        val listEmployee = ArrayList<Employee>()
        val sheet = workbook.getSheetAt(0)

        for (row in sheet){
            val cell2 = row.getCell(2)

            val list = cell2.toString().split(" ")
            if (list.size == 3){
                listEmployee.add(Employee(name = list[2], surname = list[1], profession = ProfessionEnum.OPERATOR))
            }
        }
        return listEmployee
    }
}