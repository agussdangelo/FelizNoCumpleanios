package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class PruebaAutomatizada {

	@Test
	public void QueAlComprarUnAlimentoSeDescuenteElDineroDisponible() {
		Personaje alicia = new Personaje(180, 50.0, "Alicia", 15, 45000.0);
		Supermercado mercado = new Supermercado();
		Alimento masitas = new Achicador("Masitas", 2000.0);
		mercado.agregarAlimentoAchicador(masitas);
		Boolean comprarAlimento = alicia.comprarAlimentoAchicador(mercado, masitas);
		mercado.alimentoAchicadorConsumido(masitas);
		Double cantidadDineroEsperado = 43000.0;
		Integer cantidadDeAlimentos = 0;
		assertTrue(comprarAlimento);
		assertEquals(cantidadDineroEsperado, alicia.getDinero());
		assertEquals(cantidadDeAlimentos, mercado.cantidadDeAchicadores());
	}

	@Test
	public void QueNoSeExcedaDelDineroDisponible() {
		Personaje alicia = new Personaje(180, 50.0, "Alicia", 15, 1000.0);
		Supermercado mercado = new Supermercado();
		Alimento masitas = new Achicador("Masitas", 2000.0);
		Boolean comprarAlimento = alicia.comprarAlimentoAchicador(mercado, masitas);
		Double cantidadDineroEsperado = 1000.0;
		assertFalse(comprarAlimento);
		assertEquals(cantidadDineroEsperado, alicia.getDinero());
	}
	
	@Test
	public void QueAlConsumirUnAlimentoVerificarQueSeAgrande() {
		Personaje alicia = new Personaje(180, 50.0, "Alicia", 15, 45000.0);
		Alimento caramelos = new Agrandador("Caramelos", 1500.0);
		alicia.consumirAlimento(caramelos);
		Integer alturaEsperada = 220;
		assertEquals(alturaEsperada, alicia.getAltura());
	}
	
	@Test
	public void QueAlConsumirUnAlimentoVerificarQueNoSePuedaAgrandarMasDe280cm() {
		Personaje alicia = new Personaje(180, 50.0, "Alicia", 15, 45000.0);
		Alimento caramelos = new Agrandador("Caramelos", 1500.0);
		Alimento gomitas = new Agrandador("Gomitas", 1000.0);
		Alimento bocaditos = new Agrandador("Bocaditos", 7000.0);
		alicia.consumirAlimento(caramelos);
		alicia.consumirAlimento(gomitas);
		alicia.consumirAlimento(bocaditos);
		Integer alturaEsperada = 280;
		assertEquals(alturaEsperada, alicia.getAltura());
	}
	
	@Test
	public void QueAlConsumirUnAlimentoVerificarQueSeEncoja() {
		Personaje alicia = new Personaje(180, 50.0, "Alicia", 15, 45000.0);
		Alimento bagels = new Achicador("bagels", 5600.0);
		alicia.consumirAlimento(bagels);
		Integer alturaEsperada = 130;
		assertEquals(alturaEsperada, alicia.getAltura());
	}
	
	@Test
	public void QueAlConsumirUnAlimentoVerificarQueNoSePuedaAchicarMenosDe50cm() {
		Personaje alicia = new Personaje(180, 50.0, "Alicia", 15, 45000.0);
		Alimento bagels = new Achicador("bagels", 5600.0);
		Alimento alfajores = new Achicador("Alfajores", 2300.0);
		Alimento masitas = new Achicador("Masita", 2890.0);
		Alimento alfajores2 = new Achicador("Alfajores", 2300.0);
		alicia.consumirAlimento(bagels);
		alicia.consumirAlimento(alfajores);
		alicia.consumirAlimento(alfajores2);
		alicia.consumirAlimento(masitas);
		Integer alturaEsperada = 50;
		assertEquals(alturaEsperada, alicia.getAltura());
	}
	
	// En este caso los ordene de forma del abecedario
	@Test
	public void VerificarQueLaColecciónDeAlimentosQuedeOrdenadaPorNombreDeManeraDescendente() {
		Supermercado mercado = new Supermercado();
		Alimento bagels = new Achicador("Bagels", 5600.0);
		Alimento alfajores = new Achicador("Alfajores", 2300.0);
		Alimento masitas = new Achicador("Masita", 2890.0);
		mercado.agregarAlimentoAchicador(bagels);
		mercado.agregarAlimentoAchicador(alfajores);
		mercado.agregarAlimentoAchicador(masitas);
		Integer cantidadAlimentos = 3;
		TreeSet<Alimento> alimentosEncontrados = mercado.devolverAlimentosOrdenadosPorNombre();
		assertEquals(alfajores ,alimentosEncontrados.first());
		assertEquals(masitas, alimentosEncontrados.last());
		assertEquals(cantidadAlimentos, mercado.cantidadDeAchicadores());
	}
	
}
