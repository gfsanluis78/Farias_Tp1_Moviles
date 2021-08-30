package com.farias.farias_tp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class UsbConectado extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        if (intent.getExtras().getBoolean("connected"))
        {

            String numero = "912";
            Uri llamar = Uri.parse("tel:" + numero);
            Intent emergencia = new Intent(Intent.ACTION_CALL, llamar);


            context.startActivity(emergencia);
        }

    }
}