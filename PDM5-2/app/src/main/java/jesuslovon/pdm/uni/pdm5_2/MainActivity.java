package jesuslovon.pdm.uni.pdm5_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button volverBtn, salvarBtn;
    private Button imageBtn;
    private TextView lt1, lt2, lt3, lt4;
    private EditText editText;
    private CheckBox cb1;
    private RadioButton rb1, rb2;
    private ToggleButton tb1;
    private RatingBar rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViews();

        volverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setUpViews(){
        volverBtn = (Button) findViewById(R.id.btnVolver);
        salvarBtn = (Button) findViewById(R.id.btnSalvar);
        imageBtn = (Button) findViewById(R.id.imageButton);
        lt1 = (TextView) findViewById(R.id.textView0);
        lt2 = (TextView) findViewById(R.id.textView);
        lt3 = (TextView) findViewById(R.id.textView2);
        lt4 = (TextView) findViewById(R.id.textView3);

        editText = (EditText) findViewById(R.id.editText);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);

        tb1 = (ToggleButton) findViewById(R.id.toggleButton);
        rb3 = (RatingBar) findViewById(R.id.ratingBar);

    }

    public void sendClick(View v) {
        // Perform action on clicks
        String allText = new String("campo:" + editText.getText());
        allText = allText + ":checkbox:";
        if (cb1.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }

        allText = allText + ":toggle:";
        if (tb1.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }

        allText = allText + "radios:rojo:";
        String redtext = "";
        if (rb1.isChecked()) {
            redtext = "pulsado:";
        } else {
            redtext = "no pulsado:";
        }

        allText = allText + redtext;
        allText = allText + "azul";
        String bluetext = "";
        if (rb2.isChecked()) {
            bluetext = "pulsado:";
        } else {
            bluetext = "no pulsado:";
        }
        allText = allText + bluetext;
        allText = allText + "rating:";
        float f = rb3.getRating();
        allText = allText + Float.toString( f ) + ":";

        Log.d("app", allText);
        Toast.makeText(this, allText, Toast.LENGTH_LONG).show();
    }

    public void checkBoxClick(View v) {
        String text = "";
        if (cb1.isChecked()) {
            text = "Selected";
            salvarBtn.setEnabled(true);
            Toast.makeText(this,"Ya puedes Salvar",
                    Toast.LENGTH_LONG).show();
        } else {
            salvarBtn.setEnabled(false);
            Toast.makeText(this, "Hasta que no marques la casilla no podrás salvar",Toast.LENGTH_LONG).show();
            text = "Not selected";
        }
        Toast.makeText(this,text,
                Toast.LENGTH_SHORT).show();
    }

    public void radioClick(View v){
        if(rb1.isChecked()){
            Toast.makeText(this, "Red activado", Toast.LENGTH_SHORT).show();
        }
        if(rb2.isChecked()){
            Toast.makeText(this, "Blue activado", Toast.LENGTH_SHORT).show();
        }
    }

    public void toggleClick(View v){
        Toast.makeText(this, tb1.getText(), Toast.LENGTH_SHORT).show();
    }

}
