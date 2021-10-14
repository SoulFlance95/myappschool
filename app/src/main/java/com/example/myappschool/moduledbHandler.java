package com.example.myappschool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myappschool.moduledbConfig;


import java.util.ArrayList;
import java.util.List;





    public class moduledbHandler extends SQLiteOpenHelper {
        public moduledbHandler(Context context) {
            super(context, moduledbConfig.DATABASE_NAME, null, DATABASE_VERSION);
        }

        private static final int DATABASE_VERSION = 1;

        private static final String COLUMN_ID = "ID";
        private static final String COLUMN_NAME = "Nom";
        private static final String TABLE_NAME = "modulesdb";



        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_MODULE = "CREATE TABLE " + TABLE_NAME + " ("
                    + COLUMN_ID + " TEXT, "

                    + COLUMN_NAME + " TEXT)";

            db.execSQL(CREATE_MODULE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        }


        public void ajoutmodhandler(modules module) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues ctv = new ContentValues();

            ctv.put(COLUMN_ID, module.getIdmodule());
            ctv.put(COLUMN_NAME, module.getNommodule());

            db.insert(TABLE_NAME, null, ctv);
            db.close();


        }

        public void modifmodhandler(modules module, int id) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues ctv = new ContentValues();

            ctv.put(COLUMN_ID, module.getIdmodule());
            ctv.put(COLUMN_NAME, module.getNommodule());

            db.update(TABLE_NAME, ctv, "ID=" + id, null);
            db.close();

        }


        public void suppmodhandler(modules module) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                    new String[]{String.valueOf(module.getIdmodule())});
            db.close();
        }

        public List<modules> allmodules() {
            SQLiteDatabase db = this.getWritableDatabase();
            List<modules> moduleslist = new ArrayList<>();
            String recherche = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " + COLUMN_ID + " DESC";

            Cursor cursor = db.rawQuery(recherche, null);

            if (cursor.moveToFirst()) {
                do {
                    modules module = new modules();
                    module.setIdmodule(cursor.getString(Integer.parseInt(COLUMN_ID)));
                    module.setNommodule(cursor.getString(Integer.parseInt(COLUMN_NAME)));
                    moduleslist.add(module);
                } while (cursor.moveToNext());


            }


            return moduleslist;
        }


    }


