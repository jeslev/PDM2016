package jesuslovon.pdm.uni.pdm8_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText usernameField,passwordField;
    private TextView status,role,method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = (EditText)findViewById(R.id.user);
        passwordField = (EditText)findViewById(R.id.pass);
        status = (TextView)findViewById(R.id.textoestado);
        role = (TextView)findViewById(R.id.textrol);
        method = (TextView)findViewById(R.id.textmetodo);
    }

    public void login(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        method.setText("Get Metodo");
        new SignInActivity(this,status,role,0).execute(username,password);
    }

    public void loginPost(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        method.setText("Post Metodo");
        //new JSON(this,status,role,1).execute(username,password);
    }
}
