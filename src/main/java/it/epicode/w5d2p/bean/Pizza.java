package it.epicode.w5d2p.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Pizza extends Item{

    @ManyToMany
    @JoinTable(name = "pizze_toppings",
    joinColumns = @JoinColumn(name = "pizza_id"),
    inverseJoinColumns = @JoinColumn(name = "topping_id"))
    private List<Topping> toppings;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
