package jesuslovon.pdm.uni.pdm7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bShowPreferences =
                (Button) findViewById(R.id.btn1);
        preferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        bShowPreferences.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                String username =
                        preferences.getString("username", "n/a");
                String password = preferences.getString("password", "n/a");
                showPrefs(username, password);
            }
        });

        Button buttonChangePreferences =
                (Button) findViewById(R.id.btn2);
        buttonChangePreferences.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        updatePreferenceValue();
                    }
                });

    }

    private void updatePreferenceValue(){
        SharedPreferences.Editor edit = preferences.edit();
        String username = preferences.getString("username", "n/a");
        StringBuffer buffer = new StringBuffer();
        for (int i = username.length() - 1;  i >= 0; i--) {
            buffer.append(username.charAt(i));
        }
        edit.putString("username", buffer.toString());
        edit.commit();
        Toast.makeText(this, "Explique que realiza",
                Toast.LENGTH_LONG).show();
    }

    private void showPrefs(String username, String password){
        Toast.makeText(this, username+" - "+password, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferencias:
                Intent i = new Intent(this, MisPreferencias.class);
                startActivity(i);
                Toast.makeText(this, 	"Introduce nombre/pass",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}
