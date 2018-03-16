package com.example.senalalumiere.petit_bac.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.senalalumiere.petit_bac.classes.Appartient;
import com.example.senalalumiere.petit_bac.classes.Equipe;
import com.example.senalalumiere.petit_bac.classes.Joueur;

import java.util.ArrayList;

/**
 * Created by sena la lumiere on 12/03/2018.
 */

public class AppartientDAO extends SQLiteDB {
    private static final String TABLE_APPARTIENT = "APPARTIENT";
    private static final String ID_JOUEUR = "ID_JOUEUR";
    private static final String ID_EQUIPE = "ID_EQUIPE";

    public AppartientDAO(Context context) { super(context);}

    /* INSERT APPARTIENT */
    public boolean insertAppartient(Appartient appartient){
        ContentValues values = new ContentValues();

        values.put(ID_JOUEUR,appartient.getJoueur().getId_joueur());
        values.put(ID_EQUIPE,appartient.getEquipe().getId_equipe());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert(TABLE_APPARTIENT,null,values) > 0;

        db.close();
        return createSuccessful;
    }

    /* RETRIEVE APPARTIENT */
    public Appartient retrieveAppartient(int id, Context context){
        SQLiteDatabase db = this.getReadableDatabase();
// TODO COmprendre comme ça marche ici

        Cursor cursor = db.query(TABLE_APPARTIENT,
                new String[] { ID_JOUEUR,  ID_EQUIPE},
                ID_JOUEUR + "=?",
                new String[] { String.valueOf(id) },
                null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        JoueurDAO joueurDAO = new JoueurDAO(context);
        EquipeDAO equipeDAO = new EquipeDAO(context);

        Joueur joueur = joueurDAO.retrieveJoueur(cursor.getInt(0));
        Equipe equipe = equipeDAO.retrieveEquipe(cursor.getInt(1));

        Appartient appartient = new Appartient(joueur, equipe);

        db.close();
        return appartient;
    }

    /* GET ALL CONCERNER */
    public ArrayList<Appartient> getAllAppartient(Context context){
        SQLiteDatabase db = this.getReadableDatabase();
        JoueurDAO joueurDAO = new JoueurDAO(context);
        EquipeDAO equipeDAO = new EquipeDAO(context);

        ArrayList<Appartient> listeAppartient= new ArrayList<>();
        String query = "SELECT * FROM APPARTIENT;";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Appartient appartient = new Appartient();
                Joueur joueur = joueurDAO.retrieveJoueur(cursor.getInt(0));
                Equipe equipe = equipeDAO.retrieveEquipe(cursor.getInt(1));

                appartient.setJoueur(joueur);
                appartient.setEquipe(equipe);

                listeAppartient.add(appartient);
            } while(cursor.moveToNext());
        }
        db.close();
        return listeAppartient;
    }

    /* UPDATE APPARTIENT */
    public void updateAppartient(Appartient appartient){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_JOUEUR,appartient.getJoueur().getId_joueur());
        values.put(ID_EQUIPE,appartient.getEquipe().getId_equipe());

        db.update(TABLE_APPARTIENT, values, ID_JOUEUR + " = ? and " + ID_EQUIPE +" = ?",
                new String[] {
                        Integer.toString(appartient.getJoueur().getId_joueur()),
                        Integer.toString(appartient.getEquipe().getId_equipe())

                });

        db.close();
    }

    public void deleteAppartient(int id_equipe, int id_joueur)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_APPARTIENT, ID_JOUEUR + " = ? AND " + ID_EQUIPE + "= ?", new String[]{
                Integer.toString(id_joueur),
                Integer.toString(id_equipe)
        });
        db.close();
        System.out.println("Concerner supprimé");
    }

}

