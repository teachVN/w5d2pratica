package it.epicode.w5d2p;

import it.epicode.w5d2p.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger("w5d2p");

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Table t1 = ctx.getBean("tavolo1", Table.class);

        //logger.info("Il tavolo 1 è: " + t1);

        Menu menu = ctx.getBean("menu", Menu.class);

        menu.stampaMenu();

        Order order = new Order(t1, 7);

        List<Pizza> pizze = menu.getPizze();

        List<Drink> drinks = menu.getDrinks();

        order.setPizze(pizze);
        order.setDrinks(drinks);

        logger.info("L'ordine è: " + order);

        logger.info("Il totale dell'ordine è: " +order.totaleOrdine());
    }
}
