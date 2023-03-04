package com.example.examen.service
import com.example.examen.repository.ClienteRepository
import com.example.examen.model.Cliente
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ClienteServiceTest {
    @InjectMocks
    lateinit var clienteService: ClienteService

    @Mock
    lateinit var clienteRepository: ClienteRepository

    val clienteMock = Cliente().apply{
        id=1
        nombres=""
        email="bptobar@sudamericano.edu.ec"
    }
    @Test
    fun saveClienteCorrect(){
        Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
        val response = clienteService.save(clienteMock)
        Assertions.assertEquals(response.id, clienteMock.id)
    }


    @Test
    fun saveClienteWhenNombresIsBlank(){

        Assertions.assertThrows(Exception::class.java) {
            clienteMock.apply { nombres=" "}
            Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
            clienteService.save(clienteMock)
        }

    }
}