package com.example.notificacao

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationActionReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(
            context,
            intent.getStringExtra("msg"),
            Toast.LENGTH_LONG
        ).show()
    }
}
