package com.example.senalalumiere.petit_bac.classes;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class Appartient {
    private Joueur joueur;
    private Equipe equipe;

    public Appartient(){}

    public Appartient(Joueur joueur, Equipe equipe) {
        this.joueur = joueur;
        this.equipe = equipe;

    }

    @Override
    public String toString(){
        return (joueur +" - " + equipe);
    }

    public Joueur getJoueur() {return joueur;}

    public void setJoueur(Joueur joueur) {this.joueur = joueur;}

    public Equipe getEquipe() {return equipe;}

    public void setEquipe(Equipe equipe) {this.equipe = equipe;}
}
