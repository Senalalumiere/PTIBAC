package com.example.senalalumiere.petit_bac.classes;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class Joueur {
    private int id_joueur;
    private String nom_joueur;

    public Joueur(){}

    public Joueur(int id, String nom){
        this.id_joueur = id;
        this.nom_joueur = nom;
    }


    @Override
    public String toString(){
        return (nom_joueur);
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public String getNom_joueur() {return nom_joueur;}

    public void setNom_joueur(String nom_joueur) {
        this.nom_joueur = nom_joueur;
    }

}
