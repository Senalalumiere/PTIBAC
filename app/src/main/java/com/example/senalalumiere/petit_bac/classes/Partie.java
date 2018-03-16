package com.example.senalalumiere.petit_bac.classes;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class Partie {
    private int id_partie;
    private Equipe equipe1;
    private Equipe equipe2;

    public Partie(){}

    public Partie (int id_partie, Equipe equipe1, Equipe equipe2){
        this.id_partie = id_partie;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    @Override
    public String toString(){
        return (equipe1 + " vs " + equipe2);
    }

    public int getId_partie() {return id_partie;}

    public void setId_partie(int id_partie) {this.id_partie = id_partie;}

    public Equipe getEquipe1() {return equipe1;}

    public void setEquipe1(Equipe equipe1) {this.equipe1 = equipe1;}

    public Equipe getEquipe2() {return equipe2;}

    public void setEquipe2(Equipe equipe2) {this.equipe2 = equipe2;}

}
