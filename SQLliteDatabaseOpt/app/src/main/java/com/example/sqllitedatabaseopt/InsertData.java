package com.example.sqllitedatabaseopt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {
    Button insert;
    TextView name,position,height;
    SQLliteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        db=new SQLliteDatabaseHandler(this);
        insert=findViewById(R.id.insert);
        name=findViewById(R.id.name);
        position=findViewById(R.id.position);
        height=findViewById(R.id.height);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pname=name.getText().toString();
                String pposition=position.getText().toString();
                int pheight=Integer.parseInt(height.getText().toString());
                Player p=new Player(pname,pposition,pheight);
                db.insertData(p);
                Toast.makeText(getApplicationContext(),"Successfully inserted ",Toast.LENGTH_LONG).show();
            }
        });
    }
}
