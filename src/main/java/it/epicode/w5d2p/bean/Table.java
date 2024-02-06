package it.epicode.w5d2p.bean;

import lombok.Data;

@Data
public class Table {
    private int numero;
    private int numeroMaxCoperti;
    private double costoCoperto;
    private TableState statoTavolo;
}
