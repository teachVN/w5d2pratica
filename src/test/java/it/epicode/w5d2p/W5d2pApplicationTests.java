package it.epicode.w5d2p;

import it.epicode.w5d2p.bean.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootTest
class W5d2pApplicationTests {

	static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	static void collegaContesto(){
		ctx = new AnnotationConfigApplicationContext(W5d2pApplication.class);
	}

	@Test
	void verificaCostoAcqua(){
		Drink water = ctx.getBean("water", Drink.class);
		Assertions.assertEquals(1, water.getPrezzo());
	}
	@Test
	void verificaNumeroToppingsMenu(){
		Menu menu = ctx.getBean("menu", Menu.class);
		Assertions.assertEquals(4, menu.getToppings().size());
	}

	@ParameterizedTest
	@CsvSource({"Pizza Margherita, 200", "Pizza Margherita con salame, 500"})
	void verificaCaloriePizzeMenu(String nomePizza, int calorie){
		Menu menu = ctx.getBean("menu", Menu.class);
		Pizza p = menu.getPizze().stream().filter(pizza -> pizza.getNome().equals(nomePizza)).findAny().get();
		Assertions.assertEquals(calorie, p.getCalorie());
	}

	@Test
	void verificaCostoOrdine() throws Exception{
		Order order = ctx.getBean(Order.class);
		order.setNumeroCoperti(5);
		Menu menu = ctx.getBean("menu", Menu.class);
		List<Pizza> pizze = menu.getPizze();
		List<Drink> drinks = menu.getDrinks();
		order.setPizze(pizze);
		order.setDrinks(drinks);

		Assertions.assertEquals(24, order.totaleOrdine());
	}



	@AfterAll
	static void chiudiContesto(){
		ctx.close();
	}



}
