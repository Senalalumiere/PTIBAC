package com.example.senalalumiere.petit_bac.classes;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class Partie {
    private int id_partie;
    private int id_equipe1;
    private int id_equipe2;

    public Partie (int id_partie, int id_equipe1, int id_equipe2){
        this.id_partie = id_partie;
        this.id_equipe1 = id_equipe1;
        this.id_equipe2 = id_equipe2;
    }

    @Override
    public String toString(){
        return (id_equipe1 +" vs " + id_equipe2);
    }

    public int getId_partie() {
        return id_partie;
    }

    public void setId_partie(int id_partie) {
        this.id_partie = id_partie;
    }

    public int getId_equipe1() {
        return id_equipe1;
    }

    public void setId_equipe1(int id_equipe1) {
        this.id_equipe1 = id_equipe1;
    }

    public int getId_equipe2() {
        return id_equipe2;
    }

    public void setId_equipe2(int id_equipe2) {
        this.id_equipe2 = id_equipe2;
    }

}
