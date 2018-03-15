package co.quindio.sena.ejemplosqlite.medicamentos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import co.quindio.sena.ejemplosqlite.ConexionSQLiteHelper;
import co.quindio.sena.ejemplosqlite.R;
import co.quindio.sena.ejemplosqlite.entidades.Medicamento;
import co.quindio.sena.ejemplosqlite.utilidades.Utilidades;

public class ListaMadicamentos extends AppCompatActivity {

    ListView listViewMascota;
    ArrayList<String> listaInformacion;
    ArrayList<Medicamento> listaMedicamentos;


    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicamento);


        //conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        conn=new ConexionSQLiteHelper(getApplicationContext(),"prueba",null,1);

        listViewMascota= (ListView) findViewById(R.id.listViewMascotas);

        consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewMascota.setAdapter(adaptador);

        listViewMascota.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Medicamento medicamento = listaMedicamentos.get(pos);

                Intent intent=new Intent(ListaMadicamentos.this,DetalleMedicamento.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("medicamento", medicamento);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Medicamento medicamento =null;
        listaMedicamentos =new ArrayList<Medicamento>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_MASCOTA,null);


        while (cursor.moveToNext()){
            medicamento =new Medicamento();
            medicamento.setIdMedicamento(cursor.getInt(0));
            medicamento.setNombreMedicamento(cursor.getString(1));
            medicamento.setPadecimiento(cursor.getString(2));
            medicamento.setIdPaciente(cursor.getInt(3));

            listaMedicamentos.add(medicamento);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i = 0; i< listaMedicamentos.size(); i++){
         //   listaInformacion.add(listaMedicamentos.get(i).getIdMedicamento()+" - "
            listaInformacion.add(listaMedicamentos.get(i).getIdPaciente()+" - "
                    + listaMedicamentos.get(i).getNombreMedicamento());
        }

    }
}
