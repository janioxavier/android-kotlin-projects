package com.example.broadcastreceveir

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var receiver: ToastReceiver

    private lateinit var energiaReceiver: EnergiaReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = ToastReceiver()
        energiaReceiver = EnergiaReceiver()

        var intentFilter = IntentFilter()
        intentFilter.addAction(ToastReceiver::class.java.name)
        registerReceiver(receiver, intentFilter)

        btn_enviar.setOnClickListener {
            var i = Intent(ToastReceiver::class.java.name)
            i.putExtra("msg", "Texto enviado via broadcast pela classe ${MainActivity::class.java.name}")

            sendBroadcast(i)
        }

        var intentFilter1 = IntentFilter()

        intentFilter1.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter1.addAction(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(energiaReceiver, intentFilter1)

    }

    override fun onDestroy() {
        super.onDestroy()
        if (receiver != null) {
            unregisterReceiver(receiver)
        }
        if (energiaReceiver != null) {
            unregisterReceiver(energiaReceiver);
        }
    }
}
