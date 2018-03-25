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
import com.example.senalalumiere.petit_bac.classes.Equipe;

import java.util.ArrayList;


/**
 * Created by Pezed on 25/03/2018.
 */

public class EquipeActivity extends Activity {
    ConstraintLayout dynamicLayout;
    ConstraintLayout menuLayout;
    LayoutInflater inflater;
    ArrayList <Equipe> lEquipes;
    ArrayList <String> listTeam;
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipe_activity);
        dynamicLayout = findViewById(R.id.JoueurDynamic);
        menuTeam(dynamicLayout);
    }

    public void eActivity (View view){
        startActivity(new Intent(this, EquipeActivity.class));
    }

    public void newTeam (View view){
        menuLayout.removeAllViewsInLayout();
        inflater = getLayoutInflater();
        dynamicLayout.addView(inflater.inflate(R.layout.new_team,null));
    }

    public void menuTeam (View view){
        inflater = getLayoutInflater();
        dynamicLayout.addView(inflater.inflate(R.layout.menu_team,null));
        menuLayout = findViewById(R.id.menuteam);
    }

    public void endTeam (View view){
        EditText editxt =  (EditText) findViewById(R.id.editteamname);
        EquipeDAO equipeDAO = new EquipeDAO(this);
        Equipe newE = new Equipe(equipeDAO.getLastID()+1, editxt.getText().toString());
        equipeDAO.insertEquipe(newE);
        this.finish();
        eActivity(view);
    }

    public void listPlayer (View view){
        menuLayout.removeAllViewsInLayout();
        this.populateList();
    }


    public void populateList () {
        EquipeDAO equipeDAO = new EquipeDAO (this);
        lEquipes = equipeDAO.getAllEquipe();
        listTeam = new ArrayList<>();

        for (int i = 0; i < lEquipes.size(); i++){
            String nom = lEquipes.get(i).getNom_equipe();
            listTeam.add(nom);
        }

        adapter = new ArrayAdapter<>(this, R.layout.team_item, R.id.teamItem, listTeam);

        ListView playerList = findViewById(R.id.listTeam);

        playerList.setAdapter(adapter);

        /*playerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String playerName = ((TextView)findViewById(R.id.teamItem)).getText().toString();
                Intent intent = new Intent("com.example.senalalumiere.petit_bac.Activity.StatsActivity");
                intent.putExtra("message", teamName);
                startActivity(intent);
            }
        });*/
    }
}

