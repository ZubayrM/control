package com.zubayr.service.control.api.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@RequestMapping
interface DetailsResource {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID)

}