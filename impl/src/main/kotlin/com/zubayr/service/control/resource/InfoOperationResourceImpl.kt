package com.zubayr.service.control.resource

import com.zubayr.service.control.api.model.SetupOperationDto
import com.zubayr.service.control.api.resource.InfoOperationResource
import com.zubayr.service.control.service.InfoService

class InfoOperationResourceImpl(
        private val infoService: InfoService
) : InfoOperationResource {

    override fun add(infoDto: SetupOperationDto) = infoService.add(infoDto)

}

