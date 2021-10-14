package com.example.myappschool;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myappschool.dbHandler;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myappschool.modules;
import com.example.myappschool.moduledbHandler;
import java.util.List;

public class activity_modules extends AppCompatActivity {
    EditText txtidmodule;

    EditText txtnommodule;
    TextView txtbanner1;
    Button ajoutmodbtn;
    Button suppmodbtn;
    Button modifmodbtn;
    Button voirmodbtn;
    Button gesmodulesbtn;

    modules module= new modules();

    List<modules> allmodules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        txtbanner1= (TextView)findViewById(R.id.txtbanner1);

        txtnommodule= (EditText)findViewById(R.id.txtnommodule);
        txtidmodule= (EditText)findViewById(R.id.txtidmodule);

        ajoutmodbtn= (Button) findViewById(R.id.ajoutmodbtn);
        suppmodbtn= (Button) findViewById(R.id.suppmodbtn);
        modifmodbtn= (Button) findViewById(R.id.modifmodbtn);
        voirmodbtn= (Button) findViewById(R.id.voirmodbtn);
        gesmodulesbtn= (Button) findViewById(R.id.gesmodulesbtn);

        ajoutmodbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajoutermodule();

            }
        });

        suppmodbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                supprimermodule();
            }
        });

        modifmodbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                modifiermodule();
            }
        });
        voirmodbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
            }
        });

        gesmodulesbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent m = new Intent(activity_modules.this,MainActivity.class);
                startActivity(m);

            }
        });



    }

    public void modifiermodule(){
        int id = 0;
        String ID =txtidmodule.getText().toString();
        String Nom= txtnommodule.getText().toString();

        moduledbHandler db = new moduledbHandler(this);
        db.modifmodhandler(module, id);
        Toast.makeText(this,"Module modifié avec succés",Toast.LENGTH_SHORT).show();
        if(ID.isEmpty()||Nom.isEmpty()){

            Toast.makeText(this,"Veuillez remplir les champs nécéssaires",Toast.LENGTH_SHORT).show();
        }


    }



    public void ajoutermodule(){
        String ID =txtidmodule.getText().toString();
        String Nom= txtnommodule.getText().toString();
        moduledbHandler db = new moduledbHandler(this);
        db.ajoutmodhandler(module);
        Toast.makeText(this,"Module ajouté avec succés",Toast.LENGTH_SHORT).show();

        if(ID.isEmpty()||Nom.isEmpty()){

            Toast.makeText(this,"Veuillez remplir les champs nécéssaires",Toast.LENGTH_SHORT).show();
        }


    }

    public void supprimermodule(){
        txtidmodule.setText("");
        txtnommodule.setText("");

        moduledbHandler db = new moduledbHandler(this);
        db.suppmodhandler(module);
        Toast.makeText(this,"Module supprimé avec succés",Toast.LENGTH_SHORT).show();




    }





    }



