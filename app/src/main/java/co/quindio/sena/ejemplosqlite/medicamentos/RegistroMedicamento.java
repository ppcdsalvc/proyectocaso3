package co.quindio.sena.ejemplosqlite.medicamentos;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import co.quindio.sena.ejemplosqlite.ConexionSQLiteHelper;
import co.quindio.sena.ejemplosqlite.R;
import co.quindio.sena.ejemplosqlite.entidades.Paciente;
import co.quindio.sena.ejemplosqlite.utilidades.Utilidades;

public class RegistroMedicamento extends AppCompatActivity {

    EditText razaMascota,nombreMascota,creditos;
    Spinner comboDuenio;
    String identi="";

    ArrayList<String> listaPersonas;
    ArrayList<Paciente> personasList;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_medicamento);

        razaMascota= (EditText) findViewById(R.id.campoRaza);
        nombreMascota= (EditText) findViewById(R.id.campoNombreMascota);
        comboDuenio= (Spinner) findViewById(R.id.comboDuenioMascota);
        creditos = (EditText) findViewById(R.id.edtcreditos);


        conn=new ConexionSQLiteHelper(getApplicationContext(),"prueba",null,1);

        consultarListaPersonas();

        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter
                (this,android.R.layout.simple_spinner_item,listaPersonas);

        comboDuenio.setAdapter(adaptador);



        comboDuenio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void registrarMascota() {

            SQLiteDatabase db=conn.getWritableDatabase();

            ContentValues values=new ContentValues();
            values.put(Utilidades.CAMPO_NOMBRE_MASCOTA,nombreMascota.getText().toString());
            values.put(Utilidades.CAMPO_RAZA_MASCOTA,razaMascota.getText().toString());


            int idCombo= (int) comboDuenio.getSelectedItemId();
            identi = Integer.toString(idCombo);


            if (idCombo!=0){
                Log.i("TAMAÑO",personasList.size()+"");
                Log.i("id combo",idCombo+"");
                Log.i("id combo - 1",(idCombo-1)+"");
                int idDuenio=personasList.get(idCombo-1).getId();
                Log.i("id DUEÑO",idDuenio+"");

                values.put(Utilidades.CAMPO_ID_DUENIO,idDuenio);

                Long idResultante=db.insert(Utilidades.TABLA_MASCOTA,Utilidades.CAMPO_ID_MASCOTA,values);

                Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
                db.close();

            }else{
                Toast.makeText(getApplicationContext(),"Debe seleccionar un Dueño",Toast.LENGTH_LONG).show();
            }


    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Paciente persona=null;
        personasList =new ArrayList<Paciente>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            persona=new Paciente();
            persona.setId(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setTelefono(cursor.getString(2));

            Log.i("id",persona.getId().toString());
            Log.i("Nombre",persona.getNombre());
            Log.i("Tel",persona.getTelefono());

            personasList.add(persona);

        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaPersonas=new ArrayList<String>();
        listaPersonas.add("Seleccione");

        for(int i=0;i<personasList.size();i++){
            listaPersonas.add(personasList.get(i).getId()+" - "+personasList.get(i).getNombre());
        }

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistroMascota: registrarMascota();
        }
    }


}
