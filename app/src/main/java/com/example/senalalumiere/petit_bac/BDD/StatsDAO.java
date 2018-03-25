package com.example.senalalumiere.petit_bac.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.senalalumiere.petit_bac.classes.Joueur;
import com.example.senalalumiere.petit_bac.classes.Partie;
import com.example.senalalumiere.petit_bac.classes.Stats;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by sena la lumiere on 12/03/2018.
 */

public class StatsDAO extends SQLiteDB {
    private static final String TABLE_STATS = "STATS";
    private static final String  ID_JOUEUR = "ID_JOUEUR";
    private static final String  ID_PARTIE = "ID_PARTIE";
    private static final String  SCORE = "SCORE";

    public StatsDAO(Context context) {super(context);}

    /* INSERT STATS */
    public boolean insertStats(Stats stats){
        ContentValues values = new ContentValues();

        values.put(ID_JOUEUR,stats.getJoueur().getId_joueur());
        values.put(ID_PARTIE,stats.getPartie().getId_partie());
        values.put(ID_PARTIE,stats.getScore());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert(TABLE_STATS,null,values) > 0;

        db.close();
        return createSuccessful;
    }

    /* GET ALL STATS */
    public ArrayList<Stats> getAllStats(Context context){
        SQLiteDatabase db = this.getReadableDatabase();
        JoueurDAO joueurDAO = new JoueurDAO(context);
        PartieDAO partieDAO = new PartieDAO(context);

        ArrayList<Stats> listeStats = new ArrayList<>();
        String query = "SELECT * FROM STATS;";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Stats stats = new Stats();
                Joueur joueur = joueurDAO.retrieveJoueur(cursor.getInt(0));
                Partie partie = partieDAO.retrievePartie(cursor.getInt(1), context);

                stats.setJoueur(joueur);
                stats.setPartie(partie);
                stats.setScore(cursor.getInt(2));

                listeStats.add(stats);
            } while(cursor.moveToNext());
        }
        db.close();
        return listeStats;
    }

    /* GET ALL STATS D UN JOUEUR */
    public ArrayList<Stats> getAllStatsJoueur(Context context, int id_joueur){
    SQLiteDatabase db = this.getReadableDatabase();
    JoueurDAO joueurDAO = new JoueurDAO(context);
    PartieDAO partieDAO = new PartieDAO(context);

    ArrayList<Stats> listeStats = new ArrayList<>();
    String query = "SELECT * FROM STATS WHERE ID_JOUEUR = " + id_joueur +";";
    Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
        do {
            Stats stats = new Stats();
            Joueur joueur = joueurDAO.retrieveJoueur(cursor.getInt(0));
            Partie partie = partieDAO.retrievePartie(cursor.getInt(1), context);

            stats.setJoueur(joueur);
            stats.setPartie(partie);
            stats.setScore(cursor.getInt(2));

            listeStats.add(stats);
        } while(cursor.moveToNext());
    }
        db.close();
        return listeStats;
}


    /* UPDATE */
    public void updateStats(Stats stats){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_PARTIE,stats.getPartie().getId_partie());
        values.put(ID_JOUEUR,stats.getJoueur().getId_joueur());

        db.update(TABLE_STATS, values, ID_PARTIE + " = ? and " + ID_JOUEUR +" = ?",
                new String[] {
                        Integer.toString(stats.getPartie().getId_partie()),
                        Integer.toString(stats.getJoueur().getId_joueur())
                });

        db.close();
    }

    /* DELETE */
    public void deleteStats(int id_joueur, int id_partie)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_STATS, ID_JOUEUR + " = ? AND " + ID_PARTIE + "= ?",
                new String[]{
                    Integer.toString(id_joueur),
                    Integer.toString(id_partie)
        });
        db.close();
        System.out.println("Stats supprimé");
    }

}
