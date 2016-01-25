package uni.pdm.jesuslovon.pdm4_2_4;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button[] botones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        botones = new Button[10];
        botones[0] = (Button) findViewById(R.id.boton1);
        botones[1] = (Button) findViewById(R.id.boton2);
        botones[2] = (Button) findViewById(R.id.boton3);
        botones[3] = (Button) findViewById(R.id.boton4);
        botones[4] = (Button) findViewById(R.id.boton5);
        botones[5] = (Button) findViewById(R.id.boton6);
        botones[6] = (Button) findViewById(R.id.boton7);
        botones[7] = (Button) findViewById(R.id.boton8);
        botones[8] = (Button) findViewById(R.id.boton9);
        botones[9] = (Button) findViewById(R.id.boton10);

        botones[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.facebook.com";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        botones[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        botones[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "993966523";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        botones[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivity(intent);
            }
        });

        botones[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                startActivity(intent);
            }
        });

        botones[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", getResources().getString(R.string.mail),null));
                intent.putExtra(Intent.EXTRA_SUBJECT,getResources().getString(R.string.subject));
                startActivity(Intent.createChooser(intent, getResources().getString(R.string.envio)));
            }
        });

        botones[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        botones[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
                startActivity(intent);
            }
        });

        botones[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isGPSEnabled = false;
                Location location = null;
                double latitude=-1;
                double longitude=-1;

                LocationManager manager = (LocationManager) getBaseContext().
                        getSystemService(LOCATION_SERVICE);


                isGPSEnabled = manager
                        .isProviderEnabled(LocationManager.GPS_PROVIDER);


                if(isGPSEnabled){
                    location = manager
                            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                }
                if(location!=null){
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();

                }
                Log.d("Locacion", latitude+" - "+longitude);
            }
        });

        botones[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,getResources().getString(R.string.exit));
            }
        });
    }
}
