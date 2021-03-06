package com.example.senalalumiere.petit_bac.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.senalalumiere.petit_bac.BDD.EquipeDAO;
import com.example.senalalumiere.petit_bac.BDD.JoueurDAO;
import com.example.senalalumiere.petit_bac.R;
import com.example.senalalumiere.petit_bac.classes.Joueur;

import java.util.ArrayList;

public class JoueurActivity extends Activity {
    ConstraintLayout dynamicLayout;
    ConstraintLayout menuLayout;
    LayoutInflater inflater;
    ArrayList <Joueur> lJoueurs;
    ArrayList <String> listName;
    ArrayAdapter <String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joueur_activity);
        dynamicLayout = findViewById(R.id.JoueurDynamic);
        menuPlayer(dynamicLayout);
    }

    public void jActivity (View view){
        startActivity(new Intent(this, JoueurActivity.class));
    }

    public void newPlayer (View view){
        menuLayout.removeAllViewsInLayout();
        inflater = getLayoutInflater();
        dynamicLayout.addView(inflater.inflate(R.layout.new_player,null));
    }

    public void menuPlayer (View view){
        inflater = getLayoutInflater();
        dynamicLayout.addView(inflater.inflate(R.layout.menu_player,null));
        menuLayout = findViewById(R.id.menuplayer);
    }

    public void endPlayer (View view){
        EditText editxt =  (EditText) findViewById(R.id.editplayername);
        JoueurDAO joueurDAO = new JoueurDAO(this);
        Joueur newJ = new Joueur(joueurDAO.getLastID()+1, editxt.getText().toString());
        joueurDAO.insertJoueur(newJ);
        this.finish();
        jActivity(view);
    }

    public void listPlayer (View view){
        menuLayout.removeAllViewsInLayout();
        this.populateList();
    }


    public void populateList () {
        JoueurDAO joueurDAO = new JoueurDAO (this);
        lJoueurs = joueurDAO.getAllJoueur();
        listName = new ArrayList<>();

        for (int i = 0; i < lJoueurs.size(); i++){
            String nom = lJoueurs.get(i).getNom_joueur();
            listName.add(nom);
        }

        adapter = new ArrayAdapter<>(this, R.layout.player_item, R.id.playerItem, listName);

        ListView playerList = findViewById(R.id.listPlayer);

        playerList.setAdapter(adapter);

        playerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String playerName = ((TextView)findViewById(R.id.playerItem)).getText().toString();
                Intent intent = new Intent("com.example.senalalumiere.petit_bac.Activity.StatsActivity");
                intent.putExtra("message", playerName);
                startActivity(intent);
            }
        });
    }
}
