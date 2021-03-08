package com.zubayr.service.control.service

import com.zubayr.service.control.mapper.DetailMapper
import com.zubayr.service.control.mapper.ProductMapper
import com.zubayr.service.control.repository.DetailRepository
import com.zubayr.service.control.repository.ProductRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.util.*

/**
 * ProductService
 *
 * @author Denis_Kholmogorov
 */
@Service
class ProductService(
        private val productRepository: ProductRepository,
        private val detailRepository: DetailRepository
) {

    private val productMapper = Mappers.getMapper(ProductMapper::class.java)

    private val detailMapper = Mappers.getMapper(DetailMapper::class.java)

    fun getById(id: UUID) = productRepository.getById(id)?.let { product ->
            productMapper.convertToDto(product).apply {
                details = detailRepository.getAllByProductId(id).map { detail -> detailMapper.convertToDto(detail) }
            }
        }


}