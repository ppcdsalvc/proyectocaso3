package co.quindio.sena.ejemplosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.quindio.sena.ejemplosqlite.medicamentos.ListaMadicamentos;
import co.quindio.sena.ejemplosqlite.medicamentos.RegistroMedicamento;
import co.quindio.sena.ejemplosqlite.pacientes.ConsultarPacientes;
import co.quindio.sena.ejemplosqlite.pacientes.ListaPacientesRecycler;
import co.quindio.sena.ejemplosqlite.pacientes.RegistroPacientes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"prueba",null,1);
    }

    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnOpcionRegistro:
                miIntent=new Intent(MainActivity.this,RegistroPacientes.class);
                break;
            case R.id.btnRegistroMascota:
                miIntent=new Intent(MainActivity.this,RegistroMedicamento.class);
                break;
            case R.id.btnConsultaIndividual:
                miIntent=new Intent(MainActivity.this,ConsultarPacientes.class);
                break;
            case R.id.btnConsultaListaMascota:
                miIntent=new Intent(MainActivity.this,ListaMadicamentos.class);
                break;
            case R.id.btnConsultaListaPersonasRecycler:
                miIntent=new Intent(MainActivity.this,ListaPacientesRecycler.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }
}
