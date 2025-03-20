package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComercialTest {

	Comercial comercial, comercial2, comercial3;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		comercial = new Comercial("29303132R", "Juan", "Perez", 1500.0, 30);
		comercial2 = new Comercial("20303232Y", "Maria", "Alonso", 1500.0, 10);
		comercial3 = new Comercial("21303632P", "Pedro", "Ruiz", 1500.0, 40);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Prueba para el metodo getVentas()")
	void testGetVenta() {
		double ventasEsperadas = 30.0;
		
		assertEquals(ventasEsperadas, comercial.getVentas());
	}
	
	@Test
	@DisplayName("Prueba para el metodo setVentas() con valor positivo")
	void testSetVentasPositivo() {
		double ventasActualizadas = 50.0;
		comercial.setVentas(ventasActualizadas);
		
		assertEquals(ventasActualizadas, comercial.getVentas());
	}
	
	@Test
	@DisplayName("Prueba para el metodo setVentas() con valor negativo")
	void testSetVentaNegativo() {
		double ventasActualizadas = -50.0;
		String mensajeEsperado = "Las ventas no pueden ser negativas";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> comercial.setVentas(ventasActualizadas));
		assertEquals(mensajeEsperado, exception.getMessage());
	}
	
	@Test
	@DisplayName("Prueba para el metodo calcularExtra()")
	void testCalcularExtra() {
		double extraEsperado = 0.10 * comercial.getVentas();
		
		assertEquals(extraEsperado, comercial.calcularExtra());
	}
	
	@Test
	@DisplayName("Prueba para el metodo getSueldo()")
	void testGetSueldo() {
		double sueldoComercial1 = 1500.0 + (0.10 * comercial.getVentas());
		double sueldoComercial2 = 1500.0 + (0.10 * comercial2.getVentas());
		double sueldoComercial3 = 1500.0 + (0.10 * comercial3.getVentas());
		
		assertEquals(sueldoComercial1, comercial.getSueldo());
		assertEquals(sueldoComercial2, comercial2.getSueldo());
		assertEquals(sueldoComercial3, comercial3.getSueldo());
	}

}
