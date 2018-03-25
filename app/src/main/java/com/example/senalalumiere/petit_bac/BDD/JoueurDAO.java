package com.example.senalalumiere.petit_bac.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.senalalumiere.petit_bac.classes.Joueur;

import java.util.ArrayList;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class JoueurDAO extends SQLiteDB {
    private static final String TABLE_JOUEUR = "JOUEUR";
    private static final String ID_JOUEUR = "ID_JOUEUR";
    private static final String NOM_JOUEUR = "NOM_JOUEUR";


    public JoueurDAO (Context context) {
        super(context);
    }


    /* INSERT JOUEUR */
    public boolean insertJoueur(Joueur joueur){
        ContentValues values = new ContentValues();

        values.put(NOM_JOUEUR,joueur.getNom_joueur());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean insertSuccessful = db.insert(TABLE_JOUEUR,null,values) > 0;

        /* on insert egalement son appartenance a aucune equipe */
        ContentValues values2 = new ContentValues();
        values2.put(ID_JOUEUR,joueur.getId_joueur());
        values2.put("ID_EQUIPE",1);
        db.insert("APPARTIENT",null,values2);
        return insertSuccessful;
    }

    /*GET LAST ID*/
    public int getLastID (){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT MAX(ID_JOUEUR) FROM JOUEUR;";
        Cursor cursor = db.rawQuery(query,null);
        if (cursor != null) cursor.moveToFirst();
        db.close();

        return cursor.getInt(0);
    }

    /* get all Joueur */
    public ArrayList<Joueur> getAllJoueur(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Joueur> listeJoueur= new ArrayList<>();
        String query = "SELECT * FROM JOUEUR;"; //TODO a verifier
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Joueur joueur = new Joueur();
                joueur.setId_joueur(cursor.getInt(0));
                joueur.setNom_joueur(cursor.getString(1));

                listeJoueur.add(joueur);
            } while(cursor.moveToNext());
        }
        db.close();
        return listeJoueur;
    }

    /* get all joueur d'une equipe */
    public ArrayList<Joueur> getAllJoueurOfTeam(int id_equipe){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Joueur> listeJoueur= new ArrayList<>();
        String query =
                "SELECT * FROM JOUEUR NATURAL JOIN APPARTIENT" +
                        " WHERE APPARTIENT.ID_EQUIPE = " + id_equipe +
                        ";";

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){ /* Si le curseur est pas null, on le place au début de la liste */
            do {
                Joueur joueur = new Joueur();
                joueur.setId_joueur(cursor.getInt(0));
                joueur.setNom_joueur(cursor.getString(1));

                listeJoueur.add(joueur); /* Ajout du joueur valorisée dans la liste */
            } while(cursor.moveToNext()); /* Tant qu'il reste des éléments à traiter */
        }
        db.close();
        return listeJoueur;
    }

    /* retrieveJoueur */
    public Joueur retrieveJoueur(int id_joueur){

        SQLiteDatabase db = this.getReadableDatabase();

        /* Requete */
        Cursor cursor = db.query(TABLE_JOUEUR, // Nom table
                new String[] { ID_JOUEUR, NOM_JOUEUR}, // Liste des colonnes
                ID_JOUEUR + "=?",  // Colonne cible du WHERE
                new String[] { String.valueOf(id_joueur) }, // Valeure cible du WHERE
                null, null, null, null); // Options
        if (cursor != null) cursor.moveToFirst();

        /* On récupère chaque élément dans l'ordre de la table (Haut en bas) */
        Joueur joueur = new Joueur(cursor.getInt(0),cursor.getString(1));
        db.close();
        return joueur;
    }


    public void updateJoueur(Joueur joueur){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOM_JOUEUR,joueur.getNom_joueur());
        db.update(TABLE_JOUEUR, values, ID_JOUEUR + "="+ joueur.getId_joueur(), null);
        db.close();
    }

    public  void deleteJoueur(Context context, int id_joueur) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Supprimer le joueur
        db.delete(TABLE_JOUEUR, ID_JOUEUR + "=" + id_joueur, null);
        System.out.println("Joueur Id : " + id_joueur + " supprimé");

        db.close();
    }
}

