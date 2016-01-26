package uni.pdm.jesuslovon.pdm4_4_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

public class VibraterReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        Vibrator mVibrator =
                (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        mVibrator.vibrate(500);
    }
}
