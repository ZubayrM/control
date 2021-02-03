package com.zubayr.control.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Message(msg: String) {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?=null

        var text: String? = msg


}

