package co.quindio.sena.ejemplosqlite.pacientes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import co.quindio.sena.ejemplosqlite.ConexionSQLiteHelper;
import co.quindio.sena.ejemplosqlite.R;
import co.quindio.sena.ejemplosqlite.adaptadores.ListaPersonasAdapter;
import co.quindio.sena.ejemplosqlite.entidades.Paciente;
import co.quindio.sena.ejemplosqlite.utilidades.Utilidades;

public class ListaPacientesRecycler extends AppCompatActivity {

    ArrayList<Paciente> listaPaciente;
    RecyclerView recyclerViewUsuarios;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas_recycler);

        //conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        conn=new ConexionSQLiteHelper(getApplicationContext(),"prueba",null,1);

        listaPaciente =new ArrayList<>();

        recyclerViewUsuarios= (RecyclerView) findViewById(R.id.recyclerPersonas);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));

        consultarListaPersonas();

        ListaPersonasAdapter adapter=new ListaPersonasAdapter(listaPaciente);
        recyclerViewUsuarios.setAdapter(adapter);

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Paciente paciente =null;
       // listaUsuarios=new ArrayList<Paciente>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            paciente =new Paciente();
            paciente.setId(cursor.getInt(0));
            paciente.setNombre(cursor.getString(1));
            paciente.setTelefono(cursor.getString(2));
            paciente.setDireccion(cursor.getString(3));
            paciente.setEmail(cursor.getString(4));
            paciente.setFecha(cursor.getString(5));

            listaPaciente.add(paciente);
        }
    }

    private void llenarListaUsuarios() {
      //  listaPaciente.add(new Paciente(1,"Carlos","Reforma 187","3111362665","2018-02-25"));

    }
}
