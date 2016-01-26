package uni.pdm.jesuslovon.pdm4_4_4;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public int numMessages = 0;
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);


    }

    public void lanza(View v){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this) .setSmallIcon(R.drawable
                        .ic_launcher).setContentTitle("Mi notificación")
                        .setContentText("Hola Mundo!");
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        int mNotificationId = 001;
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
    public void cambia(View v){
        NotificationManager mNotificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        int notifyID = 1;
        NotificationCompat.Builder mNotifyBuilder =
                new NotificationCompat.Builder(this)
                        .setContentTitle("Nuevo Mensaje")
                        .setContentText("Tienes mensajes nuevos!")
                        .setSmallIcon(R.drawable.ic_launcher);
        String currentText="Texto";
        mNotifyBuilder.setContentText(currentText).setNumber(++numMessages);
        mNotificationManager.notify( notifyID,  mNotifyBuilder.build());
    }

    public void borra(View v){
        NotificationManager mNotificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        int notifyID = 1;
        mNotificationManager.cancel(notifyID);
    }
}
