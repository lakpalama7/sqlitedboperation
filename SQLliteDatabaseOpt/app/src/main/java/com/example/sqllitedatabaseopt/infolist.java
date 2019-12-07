package com.example.sqllitedatabaseopt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class infolist extends AppCompatActivity {
    private SQLliteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infolist);
        db=new SQLliteDatabaseHandler(this);


        List<Player> list=db.getAllPlayers();
        if(list!=null) {
            String[] playerlist = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                playerlist[i] = list.get(i).toString();
            }

            ListView listview = findViewById(R.id.listview);
            listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, playerlist));
        }
    }
}
