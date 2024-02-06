package it.epicode.w5d2p.bean;

import lombok.Data;

import java.util.List;

@Data
public class Pizza extends Item{
    private List<Topping> toppings;
}
