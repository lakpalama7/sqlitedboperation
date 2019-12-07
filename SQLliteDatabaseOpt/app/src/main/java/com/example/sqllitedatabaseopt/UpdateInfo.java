package com.example.sqllitedatabaseopt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateInfo extends AppCompatActivity {

    EditText id,name,position,height;
    Button update;
    SQLliteDatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);
        db=new SQLliteDatabaseHandler(this);

        update=findViewById(R.id.update);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        position=findViewById(R.id.position);
        height=findViewById(R.id.height);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player p=new Player();
                p.setId(Integer.parseInt(id.getText().toString()));
                p.setName(name.getText().toString());
                p.setPosition(position.getText().toString());
                p.setHeight(Integer.parseInt(height.getText().toString()));

                int i=db.updatePlayer(p);
                if(i>0){
                    Toast.makeText(getApplicationContext(),"Update Success",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot Update",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
