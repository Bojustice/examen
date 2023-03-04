package com.example.examen.service

import com.example.examen.model.Cliente
import com.example.examen.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ClienteService {
    @Autowired
    lateinit var clienteRepository: ClienteRepository

    fun list(): List<Cliente> {
        return clienteRepository.findAll()
    }

    fun save(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    fun list (pageable: Pageable, cliente:Cliente): Page<Cliente> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return clienteRepository.findAll(Example.of(cliente, matcher), pageable)
    }

}