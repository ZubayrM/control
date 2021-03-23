package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.SetupOperationDto
import com.zubayr.service.control.api.resource.OperationResource
import com.zubayr.service.control.service.InfoService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class OperationResourceImpl(
        private val infoService: InfoService
) : OperationResource {

    override fun add(infoDto: SetupOperationDto) = infoService.add(infoDto)

}