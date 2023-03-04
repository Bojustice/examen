package com.example.examen.service

import com.example.examen.model.Factura
import com.example.examen.model.Factura_View
import com.example.examen.repository.FacturaRepository
import com.example.examen.repository.Factura_ViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class Factura_ViewService {
    @Autowired
    lateinit var factura_viewRepository: Factura_ViewRepository

    fun list(): List<Factura_View> {
        return factura_viewRepository.findAll()
    }

    fun save(factura_view: Factura_View): Factura_View {
        return factura_viewRepository.save(factura_view)
    }

    fun list (pageable: Pageable, factura_view: Factura_View): Page<Factura_View> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return factura_viewRepository.findAll(Example.of(factura_view, matcher), pageable)
    }

}