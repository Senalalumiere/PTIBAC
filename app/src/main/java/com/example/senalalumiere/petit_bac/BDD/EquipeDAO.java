package com.example.senalalumiere.petit_bac.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.senalalumiere.petit_bac.classes.Equipe;
import com.example.senalalumiere.petit_bac.classes.Joueur;

import java.util.ArrayList;


/**
 * Created by sena la lumiere on 12/03/2018.
 */

public class EquipeDAO extends SQLiteDB {
    private static final String TABLE_EQUIPE = "EQUIPE";
    private static final String ID_EQUIPE = "ID_EQUIPE";
    private static final String NOM_EQUIPE = "NOM_EQUIPE";

    public EquipeDAO (Context context) {
        super(context);
    }

    public boolean insertEquipe(Equipe equipe){
        ContentValues values = new ContentValues();

        values.put(NOM_EQUIPE,equipe.getNom_equipe());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert(TABLE_EQUIPE,null,values) > 0;

        return createSuccessful;
    }

    /*GET LAST ID*/
    public int getLastID (){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT MAX(ID_EQUIPE) FROM EQUIPE;";
        Cursor cursor = db.rawQuery(query,null);
        if (cursor != null) cursor.moveToFirst();
        db.close();

        return cursor.getInt(0);
    }

    /* get all Equipe */
    public ArrayList<Equipe> getAllEquipe(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Equipe> listeEquipe= new ArrayList<>();
        String query = "SELECT * FROM EQUIPE;"; //TODO a verifier
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Equipe equipe = new Equipe();
                equipe.setId_equipe(cursor.getInt(0));
                equipe.setNom_equipe(cursor.getString(1));

                listeEquipe.add(equipe);
            } while(cursor.moveToNext());
        }
        db.close();
        return listeEquipe;
    }

    /* get all Joueur sans Equipe */
    public ArrayList<Joueur> getAllSansEquipe(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Joueur> listeJoueur= new ArrayList<>();
        String query = "SELECT * " +
                "FROM JOUEUR NATURAL JOIN APPARTIENT " +
                "WHERE ID_EQUIPE = '1';";
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

    /* retrieveEquipe */
    public Equipe retrieveEquipe(int id_equipe){

        SQLiteDatabase db = this.getReadableDatabase();

        /* Requete */
        Cursor cursor = db.query(TABLE_EQUIPE, // Nom table
                new String[] { ID_EQUIPE, NOM_EQUIPE}, // Liste des colonnes
                ID_EQUIPE + "=?",  // Colonne cible du WHERE
                new String[] { String.valueOf(id_equipe) }, // Valeure cible du WHERE
                null, null, null, null); // Options
        if (cursor != null) cursor.moveToFirst();

        /* On récupère chaque élément dans l'ordre de la table (Haut en bas) */
        Equipe equipe = new Equipe(cursor.getInt(0),cursor.getString(1));
        db.close();
        return equipe;
    }

    public void updateEquipe(Equipe equipe){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOM_EQUIPE,equipe.getNom_equipe());
        db.update(TABLE_EQUIPE, values, ID_EQUIPE + "="+ equipe.getId_equipe(), null);
        db.close();
    }

    public  void deleteEquipe(Context context, int id_equipe) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Supprimer l/equipe
        db.delete(TABLE_EQUIPE, ID_EQUIPE + "=" + id_equipe, null);
        System.out.println("Equipe Id : " + id_equipe + " supprimé");

        db.close();
    }

}
