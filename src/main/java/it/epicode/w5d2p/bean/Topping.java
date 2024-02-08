package it.epicode.w5d2p.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Topping extends Item{
    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> pizze;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
