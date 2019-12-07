package com.example.sqllitedatabaseopt;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button showinfo,deleteinfo,updateinfo,oneplayer,download,insert;
    private SQLliteDatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showinfo=findViewById(R.id.showinfo);
        deleteinfo=findViewById(R.id.delete);
        updateinfo=findViewById(R.id.update);
        oneplayer=findViewById(R.id.single);
        download=findViewById(R.id.download);
        insert=findViewById(R.id.insert);
        db=new SQLliteDatabaseHandler(this);
        Player p1=new Player("vinay","F",200);
        Player p2=new Player("Raju","M",300);
        Player p3=new Player("Hari","F",100);

      //  db.addPlayer(p1);
      //  db.addPlayer(p2);
       // db.addPlayer(p3);

        showinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(),infolist.class);
                    startActivity(intent);

            }
        });
        deleteinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DeleteActivity.class);
                startActivity(intent);
            }
        });
    updateinfo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),UpdateInfo.class);
            startActivity(intent);
        }
    });
    oneplayer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),ShowOnePlayer.class);
            startActivity(intent);
        }
    });
    insert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),InsertData.class);
            startActivity(intent);
        }
    });
    download.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String url="http://coderzheaven.com/sample_folder/sample_file.png";
            try{
                URL myurl=new URL(url);
                HttpURLConnection con=(HttpURLConnection) myurl.openConnection();
                con.setRequestMethod("GET");
                con.setDoOutput(true);
                con.connect();

                File sd= Environment.getExternalStorageDirectory();
                File file=new File(sd,"hi.png");
                FileOutputStream out=new FileOutputStream(file);

                InputStream in=con.getInputStream();
                int totalsize=con.getContentLength();

                byte [] mybyte=new byte[1024];
                int bufferlength=0;
                while((bufferlength=in.read(mybyte))>0){
                    out.write(mybyte,0,bufferlength);
                }
                out.close();
                Toast.makeText(getApplicationContext(),"Download Success",Toast.LENGTH_LONG).show();

            }catch(Exception e){

            }
        }
    });

    }
}
