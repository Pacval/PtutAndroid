package com.example.p1406544.ptut_android.models;

public class Exercice {
    private String note;
    private String nom;
    private String duree;
    private String difficulte;


    public Exercice(String note, String nom, String duree,String difficulte){
        this.note = note;
        this.nom = nom;
        this.duree = duree;
        this.difficulte = difficulte;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }
}
