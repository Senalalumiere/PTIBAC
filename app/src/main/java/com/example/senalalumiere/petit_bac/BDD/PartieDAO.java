package com.example.senalalumiere.petit_bac.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.senalalumiere.petit_bac.classes.Equipe;
import com.example.senalalumiere.petit_bac.classes.Partie;

import java.util.ArrayList;

/**
 * Created by sena la lumiere on 12/03/2018.
 */

public class PartieDAO extends SQLiteDB {
    private static final String TABLE_PARTIE = "PARTIE";
    private static final String ID_PARTIE = "ID_PARTIE";
    private static final String EQUIPE1 = "ID_EQUIPE1";
    private static final String EQUIPE2 = "ID_EQUIPE2";

    public PartieDAO(Context context) {super(context);}

    /* INSERT PARTIE */
    public boolean insertPartie(Partie partie){
        ContentValues values = new ContentValues();

        values.put(ID_PARTIE,partie.getId_partie());
        values.put(EQUIPE1,partie.getEquipe1().getId_equipe());
        values.put(EQUIPE2,partie.getEquipe2().getId_equipe());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert(TABLE_PARTIE,null,values) > 0;

        db.close();
        return createSuccessful;
    }

    /* RETRIEVE PARTIE */
    public Partie retrievePartie(int id_partie, Context context){
        SQLiteDatabase db = this.getReadableDatabase();

        /* Requete */
        Cursor cursor = db.query(TABLE_PARTIE, // Nom table
                new String[] { ID_PARTIE, EQUIPE1, EQUIPE2 }, // Liste des colonnes
                ID_PARTIE + "=?",  // Colonne cible du WHERE
                new String[] { String.valueOf(id_partie) }, // Valeure cible du WHERE
                null, null, null, null); // Options
        if (cursor != null) cursor.moveToFirst();

        EquipeDAO equipeDAO1 = new EquipeDAO(context);
        EquipeDAO equipeDAO2 = new EquipeDAO(context);

        Equipe equipe1 = equipeDAO1.retrieveEquipe(cursor.getInt(1));
        Equipe equipe2 = equipeDAO2.retrieveEquipe(cursor.getInt(2));

        Partie partie = new Partie(cursor.getInt(0),equipe1, equipe2);
        db.close();
        return partie;
    }

    /* GET ALL PARTIE */
    public ArrayList<Partie> getAllPartie(Context context){
        SQLiteDatabase db = this.getReadableDatabase();
        EquipeDAO equipeDAO1 = new EquipeDAO(context);
        EquipeDAO equipeDAO2 = new EquipeDAO(context);

        ArrayList<Partie> listePartie = new ArrayList<>();
        String query = "SELECT * FROM PARTIE;";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Partie partie = new Partie();

                Equipe equipe1 = equipeDAO1.retrieveEquipe(cursor.getInt(1));
                Equipe equipe2 = equipeDAO2.retrieveEquipe(cursor.getInt(2));

                partie.setId_partie(cursor.getInt(0));
                partie.setEquipe1(equipe1);
                partie.setEquipe2(equipe2);

                listePartie.add(partie);
            } while(cursor.moveToNext());
        }
        db.close();
        return listePartie;
    }

    /* GET ALL PARTIE D UNE EQUIPE  */
    public ArrayList<Partie> getAllPartieEquipe1(Context context, int id_equipe){
        SQLiteDatabase db = this.getReadableDatabase();
        EquipeDAO equipeDAO1 = new EquipeDAO(context);
        EquipeDAO equipeDAO2 = new EquipeDAO(context);

        ArrayList<Partie> listePartie= new ArrayList<>();
        String query = "SELECT * FROM PARTIE WHERE ID_EQUIPE1 = " + id_equipe + " OR ID_EQUIPE2 = " + id_equipe +";";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Partie partie = new Partie();
                Equipe equipe1 = equipeDAO1.retrieveEquipe(cursor.getInt(1));
                Equipe equipe2 = equipeDAO2.retrieveEquipe(cursor.getInt(2));

                partie.setId_partie(cursor.getInt(0));
                partie.setEquipe1(equipe1);
                partie.setEquipe2(equipe2);

                listePartie.add(partie);
            } while(cursor.moveToNext());
        }
        db.close();
        return listePartie;
    }

    /* GET SCORE TOTAL DE L EQUIPE DANS UNE PARTIE */
    public Integer getScorePartie(Context context, int id_equipe, int id_partie){
        SQLiteDatabase db = this.getReadableDatabase();
        EquipeDAO equipeDAO1 = new EquipeDAO(context);
        EquipeDAO equipeDAO2 = new EquipeDAO(context);
        Integer total = 0;


        String query = "SELECT SCORE FROM PARTIE " +
                "NATURAL JOIN EQUIPE " +
                "NATURAL JOIN STATS " +
                "NATURAL JOIN APPARTIENT " +
                "WHERE ID_EQUIPE = " + id_equipe + " AND ID_PARTIE = " + id_partie +";";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                total = total + cursor.getInt(0);

            } while(cursor.moveToNext());
        }
        db.close();
        return total;
    }

    /* UPDATE PARTIE */
    public void updatePartie(Partie partie){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(EQUIPE1,partie.getEquipe1().getId_equipe());
        values.put(EQUIPE2,partie.getEquipe2().getId_equipe());

        db.update(TABLE_PARTIE, values, ID_PARTIE + " = " + partie.getId_partie(), null);

        db.close();
    }

    /* DELETE PARTIE */
    public void deletePartie(int id_partie, Context context)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_PARTIE, ID_PARTIE + " =  " + id_partie, null );
        db.close();
        System.out.println("Partie supprimé");
    }
}
