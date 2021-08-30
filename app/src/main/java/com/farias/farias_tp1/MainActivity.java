package com.farias.farias_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private UsbConectado usbCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pido permiso explicitamente dependiendo de la version de android. (mayor que 6 es obligatorio)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        usbCon = new UsbConectado();
        registerReceiver(usbCon,new IntentFilter("android.hardware.usb.action.USB_STATE")); //Intent.ACTION_POWER_CONNECTED //android.hardware.usb.action.USB_STATE
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(usbCon);
    }
}