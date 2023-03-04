package com.example.examen.model

import java.util.Date
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@Table(name="factura")
class Factura {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? =null
    @NotBlank(message="Obligatorio")
    var fecha: Date? = null
    @NotBlank
    var total: Double? = null
    @Column(name= "cliente_id")
    var clienteId: Long? = null
}