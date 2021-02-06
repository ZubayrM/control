package com.zubayr.service.control.domain.model

import com.zubayr.service.control.domain.model.Enum.StageEnum
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "detail")
data class Detail (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: UUID? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "designation")
        val designation: String? = null,

        @Column(name = "route")
        val route: String? = null,

        @Column(name = "material")
        val material: String? = null,

        @ManyToOne
        @Column (name = "product_id")
        val product: Product? = null,

        @Column(name = "stage")
        val stage: StageEnum? = null,

        @OneToMany(
                mappedBy = "detail",
                fetch = FetchType.LAZY
        )
        val operations: List<Operation>? = null



)