package uni.pdm.jesuslovon.pdm4_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String varString = getIntent().getStringExtra("valorTest");
        Log.d("HelloWorld-Second", varString);

        setTitle("second Activity");
    }


}
