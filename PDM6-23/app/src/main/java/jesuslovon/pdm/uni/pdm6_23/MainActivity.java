package jesuslovon.pdm.uni.pdm6_23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ControlLogin ctlLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctlLogin = (ControlLogin)findViewById(R.id.CtlLogin);
        ctlLogin.setOnLoginListener(new OnLoginListener() {
            @Override
            public void onLogin(String usuario, String password) {
                if (usuario.equals("demo") && password.equals("demo"))
                    ctlLogin.setMensaje("Login correcto!");
                else
                    ctlLogin.setMensaje("Vuelva a intentarlo.");
            }
        });
    }
}
