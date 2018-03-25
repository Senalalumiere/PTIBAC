package com.example.senalalumiere.petit_bac.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sena la lumiere on 09/03/2018.
 */

public class SQLiteDB extends SQLiteOpenHelper {
    protected static final String DATABASE_NAME = "BAC";
    private static final int DATABASE_VERSION = 1;



    /*CREATE*/

    private static final String CREATE_TABLE_JOUEUR = "CREATE TABLE JOUEUR" +
            "(" +
            "ID_JOUEUR INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "NOM_JOUEUR STRING NOT NULL" +
            ");";

    private static final String CREATE_TABLE_EQUIPE = "CREATE TABLE EQUIPE" +
            "(" +
            "ID_EQUIPE INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "NOM_EQUIPE STRING NOT NULL" +
            ");";

    private static final String CREATE_TABLE_APPARTIENT = "CREATE TABLE APPARTIENT" +
            "(" +
            "ID_JOUEUR INTEGER NOT NULL PRIMARY KEY," +
            "ID_EQUIPE INTEGER NOT NULL ," +
            "FOREIGN KEY (ID_JOUEUR) REFERENCES JOUEUR (ID_JOUEUR) ON DELETE CASCADE," +
            "FOREIGN KEY (ID_EQUIPE) REFERENCES EQUIPE (ID_EQUIPE) ON DELETE SET NULL" +
            ");";

    private static final String CREATE_TABLE_PARTIE = "CREATE TABLE PARTIE" +
            "(" +
            "ID_PARTIE INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "ID_EQUIPE1 INTEGER NOT NULL, " +
            "ID_EQUIPE2 INTEGER NOT NULL, " +
            "FOREIGN KEY (ID_EQUIPE1) REFERENCES EQUIPE (ID_EQUIPE) ON DELETE SET NULL," +
            "FOREIGN KEY (ID_EQUIPE2) REFERENCES EQUIPE (ID_EQUIPE) ON DELETE SET NULL" +
            ");";

    private static final String CREATE_TABLE_STATS = "CREATE TABLE STATS" +
            "(" +
            "ID_JOUEUR INTEGER NOT NULL," +
            "ID_PARTIE INTEGER NOT NULL, " +
            "SCORE INTEGER NOT NULL," +
            "PRIMARY KEY (ID_JOUEUR, ID_PARTIE)," +
            "FOREIGN KEY (ID_JOUEUR) REFERENCES JOUEUR (ID_JOUEUR) ON DELETE SET NULL," +
            "FOREIGN KEY (ID_PARTIE) REFERENCES PARTIE (ID_PARTIE) ON DELETE CASCADE" +
            ");";



    // INSERTS
    // JOUEUR
    private static final String INSERT_JOHN = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('John');";
    private static final String INSERT_ELLIOT = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Elliot');";
    private static final String INSERT_CHRISTOPHER = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Christopher');";
    private static final String INSERT_CARLA = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Carla');";
    private static final String INSERT_PERRY = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Perry');";
    private static final String INSERT_JORDAN = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Jordan');";

    private static final String INSERT_ROSS = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Ross');";
    private static final String INSERT_RACHEL = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Rachel');";
    private static final String INSERT_CHANDLER = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Chandler');";
    private static final String INSERT_MONICA = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Monica');";
    private static final String INSERT_JOEY = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Joey');";
    private static final String INSERT_PHOEBE = "INSERT INTO JOUEUR (NOM_JOUEUR) VALUES ('Phoebe');";


    // EQUIPE
    private static final String INSERT_NULL = "INSERT INTO EQUIPE (NOM_EQUIPE) VALUES ('SANS_EQUIPE');";
    private static final String INSERT_SCRUBS = "INSERT INTO EQUIPE (NOM_EQUIPE) VALUES ('SCRUBS');";
    private static final String INSERT_FRIENDS = "INSERT INTO EQUIPE (NOM_EQUIPE) VALUES ('FRIENDS');";


    // APPARTIENT
    private static final String INSERT_JOHN_APP = "INSERT INTO APPARTIENT VALUES (1, 2);";
    private static final String INSERT_ELLIOT_APP = "INSERT INTO APPARTIENT VALUES (2, 2);";
    private static final String INSERT_CHRISTOPHER_APP = "INSERT INTO APPARTIENT VALUES (3, 2);";
    private static final String INSERT_CARLA_APP = "INSERT INTO APPARTIENT VALUES (4, 2);";
    private static final String INSERT_PERRY_APP = "INSERT INTO APPARTIENT VALUES (5, 2);";
    private static final String INSERT_JORDAN_APP = "INSERT INTO APPARTIENT VALUES (6, 2);";

    private static final String INSERT_ROSS_APP = "INSERT INTO APPARTIENT VALUES (7, 3);";
    private static final String INSERT_RACHEL_APP = "INSERT INTO APPARTIENT VALUES (8, 3);";
    private static final String INSERT_CHANDLER_APP = "INSERT INTO APPARTIENT VALUES (9, 3);";
    private static final String INSERT_MONICA_APP = "INSERT INTO APPARTIENT VALUES (10, 3);";
    private static final String INSERT_JOEY_APP = "INSERT INTO APPARTIENT VALUES (11, 3);";
    private static final String INSERT_PHOEBE_APP = "INSERT INTO APPARTIENT VALUES (12, 3);";

    // Partie
    private static final String INSERT_PARTIE1 = "INSERT INTO PARTIE (ID_EQUIPE1, ID_EQUIPE2) VALUES (2, 3);";
    private static final String INSERT_PARTIE2 = "INSERT INTO PARTIE (ID_EQUIPE1, ID_EQUIPE2) VALUES (3, 2);";

    // STATS
    private static final String INSERT_STATS_JOHN1 = "INSERT INTO STATS VALUES (1, 1, 80);";
    private static final String INSERT_STATS_JOHN2 = "INSERT INTO STATS VALUES (1, 2, 75);";

    private static final String INSERT_STATS_ELLIOT1 = "INSERT INTO STATS VALUES (2, 1, 72);";
    private static final String INSERT_STATS_ELLIOT2 = "INSERT INTO STATS VALUES (2, 2, 69);";

    private static final String INSERT_STATS_CHRISTOPHER1 = "INSERT INTO STATS VALUES (3, 1, 74);";
    private static final String INSERT_STATS_CHRISTOPHER2 = "INSERT INTO STATS VALUES (3, 2, 82);";

    private static final String INSERT_STATS_CARLA1 = "INSERT INTO STATS VALUES (4, 1, 86);";
    private static final String INSERT_STATS_CARLA2 = "INSERT INTO STATS VALUES (4, 2, 83);";

    private static final String INSERT_STATS_PERRY1 = "INSERT INTO STATS VALUES (5, 1, 90);";
    private static final String INSERT_STATS_PERRY2 = "INSERT INTO STATS VALUES (5, 2, 92);";

    private static final String INSERT_STATS_JORDAN1 = "INSERT INTO STATS VALUES (6, 1, 89);";
    private static final String INSERT_STATS_JORDAN2 = "INSERT INTO STATS VALUES (6, 2, 94);";

    private static final String INSERT_STATS_ROSS1 = "INSERT INTO STATS VALUES (7, 1, 85);";
    private static final String INSERT_STATS_ROSS2 = "INSERT INTO STATS VALUES (7, 2, 75);";

    private static final String INSERT_STATS_RACHEL1 = "INSERT INTO STATS VALUES (8, 1, 74);";
    private static final String INSERT_STATS_RACHEL2 = "INSERT INTO STATS VALUES (8, 2, 69);";

    private static final String INSERT_STATS_CHANDLER1 = "INSERT INTO STATS VALUES (9, 1, 94);";
    private static final String INSERT_STATS_CHANDLER2 = "INSERT INTO STATS VALUES (9, 2, 88);";

    private static final String INSERT_STATS_MONICA1 = "INSERT INTO STATS VALUES (10, 1, 91);";
    private static final String INSERT_STATS_MONICA2 = "INSERT INTO STATS VALUES (10, 2, 86);";

    private static final String INSERT_STATS_JOEY1 = "INSERT INTO STATS VALUES (11, 1, 70);";
    private static final String INSERT_STATS_JOEY2 = "INSERT INTO STATS VALUES (11, 2, 66);";

    private static final String INSERT_STATS_PHOEBE1 = "INSERT INTO STATS VALUES (12, 1, 73);";
    private static final String INSERT_STATS_PHOEBE2 = "INSERT INTO STATS VALUES (12, 2, 71);";

    private static final String PRAGMADB = "PRAGMA foreign_keys = ON;";

    @Override
    public void onOpen(SQLiteDatabase db) {

        super.onOpen(db);

        db.execSQL(PRAGMADB);

    }

    /* Constructeur */
    public SQLiteDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_JOUEUR);
        db.execSQL(CREATE_TABLE_EQUIPE);
        db.execSQL(CREATE_TABLE_APPARTIENT);
        db.execSQL(CREATE_TABLE_PARTIE);
        db.execSQL(CREATE_TABLE_STATS);

        db.execSQL(INSERT_JOHN);
        db.execSQL(INSERT_ELLIOT);
        db.execSQL(INSERT_CHRISTOPHER);
        db.execSQL(INSERT_CARLA);
        db.execSQL(INSERT_PERRY);
        db.execSQL(INSERT_JORDAN);

        db.execSQL(INSERT_ROSS);
        db.execSQL(INSERT_RACHEL);
        db.execSQL(INSERT_CHANDLER);
        db.execSQL(INSERT_MONICA);
        db.execSQL(INSERT_JOEY);
        db.execSQL(INSERT_PHOEBE);

        db.execSQL(INSERT_NULL);
        db.execSQL(INSERT_SCRUBS);
        db.execSQL(INSERT_FRIENDS);

        db.execSQL(INSERT_JOHN_APP);
        db.execSQL(INSERT_ELLIOT_APP);
        db.execSQL(INSERT_CHRISTOPHER_APP);
        db.execSQL(INSERT_CARLA_APP);
        db.execSQL(INSERT_PERRY_APP);
        db.execSQL(INSERT_JORDAN_APP);

        db.execSQL(INSERT_ROSS_APP);
        db.execSQL(INSERT_RACHEL_APP);
        db.execSQL(INSERT_CHANDLER_APP);
        db.execSQL(INSERT_MONICA_APP);
        db.execSQL(INSERT_JOEY_APP);
        db.execSQL(INSERT_PHOEBE_APP);

        db.execSQL(INSERT_PARTIE1);
        db.execSQL(INSERT_PARTIE2);

        db.execSQL(INSERT_STATS_JOHN1);
        db.execSQL(INSERT_STATS_JOHN2);

        db.execSQL(INSERT_STATS_ELLIOT1);
        db.execSQL(INSERT_STATS_ELLIOT2);

        db.execSQL(INSERT_STATS_CHRISTOPHER1);
        db.execSQL(INSERT_STATS_CHRISTOPHER2);

        db.execSQL(INSERT_STATS_CARLA1);
        db.execSQL(INSERT_STATS_CARLA2);

        db.execSQL(INSERT_STATS_PERRY1);
        db.execSQL(INSERT_STATS_PERRY2);

        db.execSQL(INSERT_STATS_JORDAN1);
        db.execSQL(INSERT_STATS_JORDAN2);

        db.execSQL(INSERT_STATS_ROSS1);
        db.execSQL(INSERT_STATS_ROSS2);

        db.execSQL(INSERT_STATS_RACHEL1);
        db.execSQL(INSERT_STATS_RACHEL2);

        db.execSQL(INSERT_STATS_CHANDLER1);
        db.execSQL(INSERT_STATS_CHANDLER2);

        db.execSQL(INSERT_STATS_MONICA1);
        db.execSQL(INSERT_STATS_MONICA2);

        db.execSQL(INSERT_STATS_JOEY1);
        db.execSQL(INSERT_STATS_JOEY2);

        db.execSQL(INSERT_STATS_PHOEBE1);
        db.execSQL(INSERT_STATS_PHOEBE2);
        System.out.println("BDD créer");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "JOUEUR");
        db.execSQL("DROP TABLE IF EXISTS " + "EQUIPE");
        db.execSQL("DROP TABLE IF EXISTS " + "APPARTIENT");
        db.execSQL("DROP TABLE IF EXISTS " + "PARTIE");
        db.execSQL("DROP TABLE IF EXISTS " + "STATS");
        onCreate(db);
    }

}
