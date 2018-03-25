package com.example.senalalumiere.petit_bac.classes;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class Stats {
    private Joueur joueur;
    private Partie partie;
    private int score;

    public Stats(){}

    public Stats(Joueur joueur, Partie partie, int score ){
        this.joueur = joueur;
        this.partie = partie;
        this.score = score;

    }

    @Override
    public String toString(){
        return (joueur + " - " + score + " - " + partie);
    }

    public Joueur getJoueur() {return joueur;}

    public void setJoueur(Joueur joueur) {this.joueur = joueur;}

    public Partie getPartie() {return partie;}

    public void setPartie(Partie partie) {this.partie = partie;}

    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}

}
