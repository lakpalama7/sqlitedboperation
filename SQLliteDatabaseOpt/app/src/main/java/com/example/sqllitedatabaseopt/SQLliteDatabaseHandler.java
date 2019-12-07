package com.example.sqllitedatabaseopt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class SQLliteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="PlayerDB";
    private static final String TABLE_NAME="Players";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_POSITION="position";
    private static final String KEY_HEIGHT="height";

    private static final String[] COLUMNS={KEY_ID,KEY_NAME,KEY_POSITION,KEY_HEIGHT};

    public SQLliteDatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE Players ("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"name TEXT,"
                +"position TEXT,"
                +"height INTEGER)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);

    }

    public void addPlayer(Player player){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(KEY_NAME,player.getName());
        c.put(KEY_POSITION,player.getPosition());
        c.put(KEY_HEIGHT,player.getHeight());
        db.insert(TABLE_NAME,null,c);
        db.close();

    }

    public void deletePlayer(Player player){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME , "id = ?", new String[]{ String.valueOf(player.getId()) } );
        db.close();
    }
    public List<Player> getAllPlayers() {
        List<Player> list=new LinkedList<>();
        String query="SELECT * FROM " +TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        Player player=null;

        if(cursor.moveToFirst()){
            do{
                player=new Player();
                player.setId(Integer.parseInt(cursor.getString(0)));
                player.setName(cursor.getString(1));
                player.setPosition(cursor.getString(2));
                player.setHeight(Integer.parseInt(cursor.getString(3)));
                list.add(player);

            }while (cursor.moveToNext());
    }
    return list;
    }

    public int updatePlayer(Player player){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(KEY_NAME,player.getName());
        value.put(KEY_POSITION,player.getPosition());
        value.put(KEY_HEIGHT,player.getHeight());

       int i= db.update(TABLE_NAME,value,"id = ?",new String[] { String.valueOf(player.getId())});
        db.close();
        return  i;
    }
    public Player getOnePlayer(Player id){
        Player p=new Player();

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.query(TABLE_NAME,COLUMNS,"id = ?",new String[]{String.valueOf(id.getId())},null,null,null,null);
        if(c!=null)
            c.moveToFirst();
            p.setId(Integer.parseInt(c.getString(0)));
            p.setName(c.getString(1));
            p.setPosition(c.getString(2));
            p.setHeight(Integer.parseInt(c.getString(3)));

        return  p;
    }
    public void insertData(Player p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(KEY_NAME,p.getName());
        value.put(KEY_POSITION,p.getPosition());
        value.put(KEY_HEIGHT,p.getHeight());
        db.insert(TABLE_NAME,null,value);
        db.close();
    }
}
