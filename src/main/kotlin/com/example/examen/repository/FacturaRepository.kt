package com.example.examen.repository
import com.example.examen.model.Factura
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FacturaRepository: JpaRepository<Factura, Long> {
    fun findById(id: Long?): Factura?

    @Query(nativeQuery = true)
    fun findTotalMoreThan(@Param("total")total: Double?):List<Factura>?
}