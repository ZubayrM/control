package com.zubayr.control.repository

import com.zubayr.control.model.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepo : CrudRepository<Message,Long> {



}