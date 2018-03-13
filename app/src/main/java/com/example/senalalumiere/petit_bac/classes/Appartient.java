package com.example.senalalumiere.petit_bac.classes;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class Appartient {
    private int id_joueur;
    private int id_equipe;

    public Appartient(int id, int id_equipe) {
        this.id_joueur = id;
        this.id_equipe = id_equipe;

    }

    @Override
    public String toString(){
        return (id_joueur +" - " + id_equipe);
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }
}
