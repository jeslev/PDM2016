package uni.pdm.jesuslovon.pdm4_3_3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEjecutar;
    private ProgressBar pbarProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEjecutar = (Button) findViewById(R.id.btns);
        pbarProgreso = (ProgressBar) findViewById(R.id.pbarProgreso);

        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(MainActivity.this,
                        MyIntentService.class);
                msgIntent.putExtra("iteraciones", 10);
                startService(msgIntent);
            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction(MyIntentService.ACTION_PROGRESO);
        filter.addAction(MyIntentService.ACTION_FIN);
        ProgressReceiver rcv = new ProgressReceiver();
        registerReceiver(rcv, filter);
    }
    public class ProgressReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ( intent.getAction().equals(
                    MyIntentService.ACTION_PROGRESO)) {
                int prog = intent.getIntExtra("progreso", 0);
                pbarProgreso.setProgress(prog);
            }
            else if(intent.getAction().equals(MyIntentService.ACTION_FIN)) {
                Toast.makeText(MainActivity.this, "Tarea finalizada!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
