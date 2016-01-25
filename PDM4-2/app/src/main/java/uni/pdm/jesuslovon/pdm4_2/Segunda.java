package uni.pdm.jesuslovon.pdm4_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Segunda extends AppCompatActivity {

    private Button boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        setTitle("Segunda Actividad");

        boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver(v);
            }
        });
    }

    public void volver(View view){
        Log.d("App", "Adios con dios");
        finish();
    }
}
