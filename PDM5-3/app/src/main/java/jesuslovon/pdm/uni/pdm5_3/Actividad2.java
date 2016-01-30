package jesuslovon.pdm.uni.pdm5_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.GridView;

public class Actividad2 extends AppCompatActivity {

    private GridView lv;

    public static final String[] comidas = {
            "arroz con pollo","ají de gallina","lomo saltado",
            "tacu tacu", "ceviche", "hostia que hambre me ha dado"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        lv = (GridView) findViewById(R.id.GrdOpciones);


        lv.setAdapter(new ComidaAdapter(this, comidas));

        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent,
                                            android.view.View v, int position, long id) {
                        Log.d("App","Opción seleccionada: "
                                + parent.getItemAtPosition(position));
                    }
                });
    }
}
