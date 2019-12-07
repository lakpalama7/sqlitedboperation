package com.example.sqllitedatabaseopt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowOnePlayer extends AppCompatActivity {
    EditText id;
    TextView name,position,height;
    Button search;
    SQLliteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_one_player);
        db=new SQLliteDatabaseHandler(this);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        position=findViewById(R.id.position);
        height=findViewById(R.id.height);

        search=findViewById(R.id.show);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player p=new Player();
                p.setId(Integer.parseInt(id.getText().toString()));
                p= db.getOnePlayer(p);
                Toast.makeText(getApplicationContext(),p.toString(),Toast.LENGTH_LONG).show();
                   name.setText(p.getName());
                   position.setText(p.getPosition());
                   height.setText(String.valueOf(p.getHeight()));
                           }
        });

    }
}
