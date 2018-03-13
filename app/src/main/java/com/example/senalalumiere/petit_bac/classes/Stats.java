package com.example.senalalumiere.petit_bac.classes;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class Stats {
    private int id_joueur;
    private int id_partie;
    private int score;


    public Stats(int id_joueur, int id_partie, int score ){
        this.id_joueur = id_joueur;
        this.id_partie = id_partie;
        this.score = score;

    }

    @Override
    public String toString(){
        return (id_joueur +" - " + score);
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public int getId_partie() {
        return id_partie;
    }

    public void setId_partie(int id_partie) {
        this.id_partie = id_partie;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
