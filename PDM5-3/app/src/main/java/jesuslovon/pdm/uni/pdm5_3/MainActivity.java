package jesuslovon.pdm.uni.pdm5_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    public static final String[] comidas = {
            "arroz con pollo","ají de gallina","lomo saltado",
            "tacu tacu", "ceviche", "hostia que hambre me ha dado"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.LstOpciones);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.lista_item , comidas);

        lv.setAdapter(new ComidaAdapter(this, comidas));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.acerca:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Jesus Lovon");
                builder1.setMessage("Codigo 20101299F");
                builder1.setCancelable(true);
                builder1.setNeutralButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
                return true;
            case R.id.config:
                Intent intent = new Intent(this, Actividad32.class);
                startActivity(intent);
                return true;
            case R.id.salir:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
