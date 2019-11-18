package com.example.broadcastreceveir

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class EnergiaReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action.equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "Conectado!!", Toast.LENGTH_LONG).show()
        }
        if (intent.action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context, "Desconectado!!", Toast.LENGTH_LONG).show()
        }
    }
}
