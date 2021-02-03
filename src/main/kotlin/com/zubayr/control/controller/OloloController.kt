package com.zubayr.control.controller

import com.zubayr.control.model.Message
import com.zubayr.control.repository.MessageRepo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OloloController(val messageRepo: MessageRepo) {



    @GetMapping("/")
    fun getAllOlolos():Iterable<Message>{
        return messageRepo.findAll()
    }

    @PostMapping("/")
    fun add(text:String):Iterable<Message>{
        messageRepo.save(Message(text))
        return messageRepo.findAll();
    }



}