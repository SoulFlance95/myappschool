package com.example.myappschool;

import static com.example.myappschool.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText txtidfiliere;
EditText txtreffiliere;
EditText txtnomfiliere;
TextView txtbanner;
Button ajoutfilbtn;
Button suppfilbtn;
Button modiffilbtn;
Button voirfilbtn;
Button gesmodulesbtn;
   filieres filiere= new filieres();

    List<filieres> allfilieres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        txtbanner= (TextView)findViewById(id.txtbanner);
        txtidfiliere= (EditText)findViewById(id.txtidfiliere);
        txtnomfiliere= (EditText)findViewById(id.txtreffiliere);
        txtidfiliere= (EditText)findViewById(id.txtidfiliere);
        txtreffiliere= (EditText)findViewById(id.txtidfiliere);

        ajoutfilbtn= (Button) findViewById(id.ajoutfilbtn);
        suppfilbtn= (Button) findViewById(id.suppfilbtn);
        modiffilbtn= (Button) findViewById(id.modiffilbtn);
        voirfilbtn= (Button) findViewById(id.voirfilbtn);
        gesmodulesbtn= (Button) findViewById(id.gesmodulesbtn);

        ajoutfilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajouterfiliere();

            }
        });

        suppfilbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                supprimerfiliere();
            }
        });

        modiffilbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                modifierfiliere();
            }
        });
        voirfilbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
 voirfilieres();

            }
        });

        gesmodulesbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent m = new Intent(MainActivity.this,activity_modules.class);

                startActivity(m);
            }
        });



    }

public void modifierfiliere(){
    int id = 0;
    String ID =txtidfiliere.getText().toString();
    String Nom= txtnomfiliere.getText().toString();
    String Ref= txtreffiliere.getText().toString();
    dbHandler db = new dbHandler(this);
    db.modifhandler(filiere, id);




    Toast.makeText(this,"Filiére modifiée avec succés",Toast.LENGTH_SHORT).show();
    if(ID.isEmpty()||Nom.isEmpty()||Ref.isEmpty()){

        Toast.makeText(this,"Veuillez remplir les champs nécéssaires",Toast.LENGTH_SHORT).show();
    }

}



    public void ajouterfiliere(){
        String ID =txtidfiliere.getText().toString();
        String Nom= txtnomfiliere.getText().toString();
        String Ref= txtreffiliere.getText().toString();
        dbHandler db = new dbHandler(this);
        db.ajouthandler(filiere);
        Toast.makeText(this,"Filiére ajoutée avec succés",Toast.LENGTH_SHORT).show();

        if(ID.isEmpty()||Nom.isEmpty()||Ref.isEmpty()){

Toast.makeText(this,"Veuillez remplir les champs nécéssaires",Toast.LENGTH_SHORT).show();
        }


    }

    public void supprimerfiliere(){
       txtnomfiliere.setText("");
        for (EditText editText : Arrays.asList(txtidfiliere, txtreffiliere)) {
            editText.setText("");
        }
        dbHandler db = new dbHandler(this);
        db.supphandler(filiere);
        Toast.makeText(this,"Filiére supprimée avec succés",Toast.LENGTH_SHORT).show();




    }

public void voirfilieres(){
    dbHandler db = new dbHandler(this);
    db.voirallfiliere();
}

}