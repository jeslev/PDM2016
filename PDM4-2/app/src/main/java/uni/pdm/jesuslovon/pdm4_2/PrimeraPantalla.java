package uni.pdm.jesuslovon.pdm4_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PrimeraPantalla extends AppCompatActivity {

    private Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);

        boton1 = (Button) findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salta(v);
            }
        });

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("valorTest","cualquier cosa");
        startActivity(intent);
    }

    public void salta(View view){
        Log.d("App", "Se ha hecho click");
        Intent intent = new Intent(this, Segunda.class);
        startActivity(intent);
    }
}
