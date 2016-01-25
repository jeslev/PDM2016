package uni.pdm.jesuslovon.pdm4_3_3;

import android.app.IntentService;
import android.content.Intent;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_PROGRESO = "uni.pdm.jesuslovon.pdm4_3_3.action.PROGRESO";
    public static final String ACTION_FIN = "uni.pdm.jesuslovon.pdm4_3_3.action.FIN";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "uni.pdm.jesuslovon.pdm4_3_3.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "uni.pdm.jesuslovon.pdm4_3_3.extra.PARAM2";


    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        int iter = intent.getIntExtra("iteraciones", 0);
        for(int i=1; i<=iter; i++) {
            tareaLarga();
            //Comunicamos el progreso
            Intent bcIntent = new Intent();
            bcIntent.setAction(ACTION_PROGRESO);
            bcIntent.putExtra("progreso", i*10);
            sendBroadcast(bcIntent);
        }
        Intent bcIntent = new Intent();
        bcIntent.setAction(ACTION_FIN);
        sendBroadcast(bcIntent);
    }

    private void tareaLarga() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) { }
    }

}
