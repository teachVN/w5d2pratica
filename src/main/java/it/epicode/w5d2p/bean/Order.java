package it.epicode.w5d2p.bean;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private static int contatore=1;
    private int numeroOrdine;
    private int numeroCoperti;
    private OrderState orderState;
    private LocalTime oraOrdine;

    private Table table;
    private List<Pizza> pizze;
    private List<Drink> drinks;

    public Order(Table table, int numeroCoperti) throws Exception{
        if(numeroCoperti<=table.getNumeroMaxCoperti())
            this.numeroCoperti=numeroCoperti;
        else
            throw new Exception("Numero max coperti del tavolo superato");

        if(table.getStatoTavolo().equals(TableState.LIBERO))
            this.table=table;
        else
            throw new Exception("Tavolo occupato");

        numeroOrdine=contatore++;
        orderState=OrderState.IN_CORSO;
        oraOrdine = LocalTime.now();

        pizze = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public double totaleOrdine(){
        double totale = table.getCostoCoperto()*numeroCoperti;

        totale = totale + pizze.stream().mapToDouble(pizza->pizza.getPrezzo()).sum() +
                drinks.stream().mapToDouble(drink-> drink.getPrezzo()).sum();
        return totale;
    }


}
