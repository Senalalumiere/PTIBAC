package com.example.senalalumiere.petit_bac.classes;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class Equipe {
    private int id_equipe;
    private String nom_equipe;

    public Equipe(){}

    public Equipe(int id_equipe, String nom){
        this.id_equipe = id_equipe;
        this.nom_equipe = nom;
    }


    @Override
    public String toString(){
        return (nom_equipe);
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }
}
