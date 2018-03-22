package com.example.senalalumiere.petit_bac.classes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.senalalumiere.petit_bac.R;

import java.util.ArrayList;

public class JoueurActivity extends Activity {
    ConstraintLayout dynamicLayout;
    ConstraintLayout menuLayout;
    LayoutInflater inflater;
    ArrayList <Joueur> lJoueurs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joueur_activity);
        dynamicLayout = findViewById(R.id.JoueurDynamic);
        menuPlayer(dynamicLayout);
    }

    public void jActivity (View view){
        startActivity(new Intent(this, com.example.senalalumiere.petit_bac.classes.JoueurActivity.class));
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
        this.finish();
        jActivity(view);
    }

    public void listPlayer (View view){
        menuLayout.removeAllViewsInLayout();
        makeList();
    }

    public void makeList (){
        if (lJoueurs != null) {
            JoueurAdapter jAdapter = new JoueurAdapter(this, lJoueurs);
            ListView lViewJoueur = (ListView) findViewById(R.id.list_player);
            lViewJoueur.setAdapter(jAdapter);
        }
    }
}
