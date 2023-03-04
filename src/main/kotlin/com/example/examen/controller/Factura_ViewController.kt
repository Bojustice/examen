package com.example.examen.controller

import com.example.examen.model.Factura
import com.example.examen.model.Factura_View
import com.example.examen.service.FacturaService
import com.example.examen.service.Factura_ViewService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/factura_view")
class Factura_ViewController {
    @Autowired
    lateinit var factura_viewService: Factura_ViewService

    @GetMapping
    fun list (factura_view: Factura_View, pageable: Pageable): ResponseEntity<*> {
        val response= factura_viewService.list(pageable, factura_view)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid factura_view: Factura_View): ResponseEntity<Factura_View> {
        return ResponseEntity (factura_viewService.save(factura_view), HttpStatus.OK)
    }

}