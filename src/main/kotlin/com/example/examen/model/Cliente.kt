package com.example.examen.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@Table(name="cliente")
class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? =null
    @NotBlank(message="Obligatorio")
    var nombres: String? = null
    @Email(message= "Formato incorrecto")
    var email: String? = null
}