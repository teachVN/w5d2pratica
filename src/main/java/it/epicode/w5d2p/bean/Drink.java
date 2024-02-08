package it.epicode.w5d2p.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Drink extends Item{

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
