package uni.pdm.jesuslovon.pdm4_4_3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

/**
 * Created by jeslev on 26/01/16.
 */
public class VibrateReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent){
        Vibrator mVibrator =
                (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        mVibrator.vibrate(500);
    }
}
