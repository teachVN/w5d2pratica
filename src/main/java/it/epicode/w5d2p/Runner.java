package it.epicode.w5d2p;

import it.epicode.w5d2p.bean.*;
import it.epicode.w5d2p.service.ItemService;
import it.epicode.w5d2p.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private ItemService itemService;

    @Autowired
    private MenuService menuService;

    private Logger logger = LoggerFactory.getLogger("w5d2p");

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d2pApplication.class);


        //Table t1 = ctx.getBean("tavolo1", Table.class);

        //logger.info("Il tavolo 1 è: " + t1);

//        Menu menu = ctx.getBean("menu", Menu.class);
//
//        menu.stampaMenu();

//        try {
//            //Order order = new Order(t1, 6);
//            Order order = ctx.getBean(Order.class);
//            //order.setNumeroOrdine(1);
//            order.setNumeroCoperti(6);
//
//            logger.info("Il tavolo 1 è: " + t1);
//
//
//            List<Pizza> pizze = menu.getPizze();
//
//            List<Drink> drinks = menu.getDrinks();
//
//            order.setPizze(pizze);
//            order.setDrinks(drinks);
//
//            logger.info("L'ordine è: " + order);
//
//            logger.info("Il totale dell'ordine è: " + order.totaleOrdine());
//         }
//        catch (Exception e){
//            logger.error(e.getMessage());

        //CREAZIONE MENU NEL DB PARTENDO DAL BEAN PRESENTE NEL CONTESTO DI SPRING
        Menu menu = ctx.getBean("menu", Menu.class);
        menu.stampaMenu();
        menuService.salvaMenu(menu);

        //CREAZIONE DEI DRINK NEL DB A PARTIRE DAI BEAN PRESENTI NEL CONTESTO DI SPRING. SET DEL MENU NEI DRINK
        Drink water = ctx.getBean("water", Drink.class);
        water.setMenu(menu);
        itemService.salvaItem(water);

        Drink cocaCola = ctx.getBean("cocaCola", Drink.class);
        cocaCola.setMenu(menu);
        itemService.salvaItem(cocaCola);


        //CREAZIONE DEI TOPPINGS NEL DB A PARTIRE DAI BEAN PRESENTI NEL CONTESTO DI SPRING. SET DEL MENU NEI TOPPING
        Topping mozzarella = ctx.getBean("mozzarella", Topping.class);
        Topping pomodoro = ctx.getBean("pomodoro", Topping.class);
        Topping salame = ctx.getBean("salame", Topping.class);
        Topping prosciutto = ctx.getBean("prosciutto", Topping.class);
        mozzarella.setMenu(menu);
        pomodoro.setMenu(menu);
        salame.setMenu(menu);
        prosciutto.setMenu(menu);
        itemService.salvaItem(mozzarella);
        itemService.salvaItem(pomodoro);
        itemService.salvaItem(salame);
        itemService.salvaItem(prosciutto);

        //CREAZIONE DELLE PIZZE NEL DB A PARTIRE DAI BEAN PRESENTI NEL CONTESTO DI SPRING. SET DEL MENU NELLE PIZZE
        Pizza margherita = ctx.getBean("margherita", Pizza.class);
        Pizza margheritaSalame = ctx.getBean("margheritaSalame", Pizza.class);
        margherita.setMenu(menu);
        margheritaSalame.setMenu(menu);
        itemService.salvaItem(margherita);
        itemService.salvaItem(margheritaSalame);





    }
}
