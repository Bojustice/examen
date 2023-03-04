package com.example.examen.controller


import com.example.examen.model.Factura
import com.example.examen.service.FacturaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/factura")
class FacturaController {
    @Autowired
    lateinit var facturaService: FacturaService

    @GetMapping
    fun list (factura:Factura, pageable: Pageable): ResponseEntity<*> {
        val response= facturaService.list(pageable, factura)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid factura:Factura): ResponseEntity<Factura> {
        return ResponseEntity (facturaService.save(factura), HttpStatus.OK)
    }
    @GetMapping("/totals/{total}")
    fun listTotals (@PathVariable("total") total: Double ):ResponseEntity<*>{
        return ResponseEntity(facturaService.listTotalMoreThan(total), HttpStatus.OK)
    }

}