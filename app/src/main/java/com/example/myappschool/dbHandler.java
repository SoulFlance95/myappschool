package com.example.myappschool;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.widget.TextView;

public class dbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

     private static final String COLUMN_ID ="ID";
     private static final String COLUMN_REF="Ref";
     private static final String COLUMN_NAME="Nom";
    private static final String TABLE_NAME = "filieresdb";
    private char title;


    public dbHandler(Context context) {
        super(context, dbConfig.DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase  db) {
        String CREATE_FILIERE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID+ " TEXT, "
                + COLUMN_REF + " TEXT,"
                + COLUMN_NAME + " TEXT)";

        db.execSQL(CREATE_FILIERE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


    public void ajouthandler(filieres filiere){
       SQLiteDatabase db= this.getWritableDatabase();
        ContentValues ctv= new ContentValues();

        ctv.put(COLUMN_ID,filiere.getIdfiliere());
        ctv.put(COLUMN_REF, filiere.getReffiliere());
        ctv.put(COLUMN_NAME,filiere.getNomfiliere());

        db.insert(TABLE_NAME,null,ctv);
        db.close();



    }

    public void modifhandler(filieres filiere, int id){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues ctv= new ContentValues();

        ctv.put(COLUMN_ID,filiere.getIdfiliere());
        ctv.put(COLUMN_REF, filiere.getReffiliere());
        ctv.put(COLUMN_NAME,filiere.getNomfiliere());

        db.update(TABLE_NAME,ctv,"ID="+id,null);
        db.close();

    }


    public void supphandler(filieres filiere){
  SQLiteDatabase db= this.getWritableDatabase();
  db.delete(TABLE_NAME, COLUMN_ID+ " = ?",
                new String[] { String.valueOf(filiere.getIdfiliere()) });
        db.close();
    }

    public void voirallfiliere(TextView textview){
        String id = null;
        Cursor resultat= this.getReadableDatabase().rawQuery("select * from "+TABLE_NAME+",WHERE ID="+id,null);
        textview.setText("");
        while(resultat.moveToNext()){
            textview.append(resultat.getString(1));
        }
    }




}

