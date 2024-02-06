package it.epicode.w5d2p.bean;

import lombok.Data;

@Data
public abstract class Item {

    private String nome;
    private int calorie;
    private double prezzo;
}
