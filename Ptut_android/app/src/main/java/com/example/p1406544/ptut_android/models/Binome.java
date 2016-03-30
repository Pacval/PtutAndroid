package com.example.p1406544.ptut_android.models;


public class Binome {
    private int numero;
    private String nom1;
    private String nom2;

    public Binome(int numero, String nom1, String nom2) {
        this.numero = numero;
        this.nom1 = nom1;
        this.nom2 = nom2;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getNom2() {
        return nom2;
    }

    public void setNom2(String nom2) {
        this.nom2 = nom2;
    }
}
