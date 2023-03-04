package com.example.examen.repository

import com.example.examen.model.Factura
import com.example.examen.model.Factura_View
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Factura_ViewRepository: JpaRepository<Factura_View, Long> {
    fun findById(id: Long?): Factura_View?
}