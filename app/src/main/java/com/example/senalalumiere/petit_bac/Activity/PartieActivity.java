package com.example.senalalumiere.petit_bac.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.senalalumiere.petit_bac.BDD.PartieDAO;
import com.example.senalalumiere.petit_bac.R;
import com.example.senalalumiere.petit_bac.classes.Equipe;
import com.example.senalalumiere.petit_bac.classes.Partie;

import java.util.ArrayList;

/**
 * Created by Pezed on 25/03/2018.
 */

public class PartieActivity extends Activity {
    ArrayList <String> scoreList;
    ArrayList <Partie> lParties;
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partie_activity);
        createPartieList();
    }

    public void pActivity (View view){
        startActivity(new Intent(this, PartieActivity.class));
    }

    public void createPartieList (){
        PartieDAO partieDAO = new PartieDAO(this);
        lParties = partieDAO.getAllPartie(this);
        scoreList = new ArrayList<>();

        for (int i = 0; i < lParties.size(); i++ ){

            String string = lParties.get(i).toString() + "\n" + partieDAO.getScorePartie(lParties.get(i).getEquipe1().getId_equipe(), lParties.get(i).getId_partie()) + " - " + partieDAO.getScorePartie(lParties.get(i).getEquipe2().getId_equipe(), lParties.get(i).getId_partie());
            scoreList.add(string);

        }

        adapter = new ArrayAdapter<>(this, R.layout.partie_item, R.id.partieItem, scoreList);

        ListView scoreView = findViewById(R.id.listPartie);

        scoreView.setAdapter(adapter);
    }
}
