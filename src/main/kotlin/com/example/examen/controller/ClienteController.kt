package com.example.examen.controller

import com.example.examen.model.Cliente
import com.example.examen.service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/cliente")
class ClienteController {
    @Autowired
    lateinit var clienteService: ClienteService

    @GetMapping
    fun list (cliente: Cliente, pageable: Pageable): ResponseEntity<*> {
        val response= clienteService.list(pageable, cliente)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid cliente:Cliente):ResponseEntity<Cliente>{
        return ResponseEntity (clienteService.save(cliente), HttpStatus.OK)
    }

}