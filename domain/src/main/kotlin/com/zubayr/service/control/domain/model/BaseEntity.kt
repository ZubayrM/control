package com.zubayr.service.control.domain.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * BaseEntity
 *
 * @author Denis_Kholmogorov
 */
@MappedSuperclass
abstract class BaseEntity : Serializable {

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    open var id: UUID? = null

    @CreatedDate
    @Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    open var createdDate: ZonedDateTime? = null

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    open var lastModifiedDate: ZonedDateTime? = null

    @Column(name = "IS_DELETED")
    open var isDeleted: Boolean = false
}