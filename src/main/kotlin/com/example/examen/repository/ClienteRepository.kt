package com.example.examen.repository
import com.example.examen.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Long> {
    fun findById(id: Long?): Cliente?
}