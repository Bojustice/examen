package com.example.examen.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="factura_view")
class Factura_View {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message = "Obligatorio")
    var fecha: Date? = null

    @NotBlank
    var total: Double? = null

    @Column(name = "cliente_id")
    var clienteId: Long? = null

    @NotBlank
    var nombres: Long? = null
}