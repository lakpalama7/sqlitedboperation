package com.example.sqllitedatabaseopt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    private SQLliteDatabaseHandler db;

    Button delete;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delete=findViewById(R.id.delete);
        id=findViewById(R.id.id);
        db=new SQLliteDatabaseHandler(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player p=new Player();
                p.setId(Integer.parseInt(id.getText().toString()));
                db.deletePlayer(p);
                Toast.makeText(getApplicationContext(),"Delete success",Toast.LENGTH_LONG).show();
            }
        });

    }
}
