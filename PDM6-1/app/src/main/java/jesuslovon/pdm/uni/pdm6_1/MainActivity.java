package jesuslovon.pdm.uni.pdm6_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements enviarMensaje {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Appbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Appbar page filter
        Spinner cmbToolbar = (Spinner) findViewById(R.id.CmbToolbar);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getSupportActionBar().getThemedContext(),
                R.layout.appbar_filter_title,
                new String[]{"Opción 1 ", "Opción 2 ", "Opción 3 "});

        adapter.setDropDownViewResource(R.layout.appbar_filter_list);
        cmbToolbar.setAdapter(adapter);
        cmbToolbar.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view,
                                               int i, long l) {
                        //... Acciones al seleccionar una opción de la lista
                        Log.i("Toolbar 3", "Seleccionada opción " + i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        //... Acciones al no existir ningún elemento seleccionado
                    }
                });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.action_opt1:
                Toast.makeText(getApplicationContext(),"Opcion 1", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_opt2:
                Toast.makeText(getApplicationContext(),"Opcion 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_opt3:
                Toast.makeText(getApplicationContext(),"Opcion 3", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void enviarDatos (String mensaje){
        Derecho derecha = (Derecho) getSupportFragmentManager().
                findFragmentById(R.id.derecho);
        derecha.obtenerMensaje(mensaje);
    }


}
