package com.example.examen.service
import com.example.examen.service.FacturaService
import com.example.examen.model.Cliente
import com.example.examen.model.Factura
import com.example.examen.repository.ClienteRepository
import com.example.examen.repository.FacturaRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class FacturaServiceTest {

    @InjectMocks
    lateinit var facturaService: FacturaService

    @Mock
    lateinit var facturaRepository: FacturaRepository

    @Mock
    lateinit var clienteRepository: ClienteRepository

    val jsonString = File("./src/test/resources/factura.json").readText(Charsets.UTF_8)
    val facturaMock = Gson().fromJson(jsonString, Factura::class.java)

    val clienteMock = Cliente().apply {
        id=1
        nombres= "Boris Tobar"
        email= "bptobar@sudamericano.edu.ec"

    }

    @Test
    fun saveInvoiceWhenIsCorrect(){
        Mockito.`when`(clienteRepository.findById(facturaMock.clienteId)).thenReturn(clienteMock)
        Mockito.`when`(facturaRepository.save(Mockito.any(Factura::class.java))).thenReturn(facturaMock)
        val response = facturaService.save(facturaMock)
        Assertions.assertEquals(response.id, facturaMock.id)
    }



}