package com.example.senalalumiere.petit_bac.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.senalalumiere.petit_bac.R;

import java.util.ArrayList;

/**
 * Created by Pezed on 22/03/2018.
 */

public class JoueurAdapter extends BaseAdapter {

    private Context oContext;
    private LayoutInflater inflater;
    private ArrayList <Joueur> listJoueurs;

    public JoueurAdapter (Context context, ArrayList <Joueur> list){

        this.oContext = context;
        this.listJoueurs = list;
        this.inflater =LayoutInflater.from(oContext);
    }


    @Override
    public int getCount() {
        return this.listJoueurs.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listJoueurs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TableLayout tLayoutItem;

        if (convertView == null ){
            tLayoutItem = (TableLayout) inflater.inflate(R.layout.player_item, parent, false);
        }
        else {
            tLayoutItem = (TableLayout) convertView;
        }

        TextView contenuPlayer = (TextView) tLayoutItem.findViewById(R.id.txtplayer);
        contenuPlayer.setText(this.listJoueurs.get(position).getNom_joueur());

        return tLayoutItem;
    }
}
