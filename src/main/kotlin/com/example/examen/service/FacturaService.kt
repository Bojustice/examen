package com.example.examen.service

import com.example.examen.model.Factura
import com.example.examen.repository.FacturaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FacturaService {
    @Autowired
    lateinit var facturaRepository: FacturaRepository

    fun list(): List<Factura> {
        return facturaRepository.findAll()
    }
    fun listTotalMoreThan(total:Double?): List<Factura>? {
        return facturaRepository.findTotalMoreThan(total)
    }

    fun save(factura:Factura): Factura {
        return facturaRepository.save(factura)
    }

    fun list (pageable: Pageable, factura:Factura): Page<Factura> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return facturaRepository.findAll(Example.of(factura, matcher), pageable)
    }

}