package com.zubayr.service.control.resource

import com.zubayr.service.control.api.resource.DetailsResource
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class DetailsResourceImpl: DetailsResource {

    override fun getById(id: UUID) {
        TODO("Not yet implemented")
    }
}