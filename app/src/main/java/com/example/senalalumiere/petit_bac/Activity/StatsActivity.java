package com.example.senalalumiere.petit_bac.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.senalalumiere.petit_bac.R;

/**
 * Created by Pezed on 25/03/2018.
 */

public class StatsActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);

        Intent intent = getIntent();

        String playerName = intent.getStringExtra("message");

        System.out.print(playerName+"\n");
    }


}
