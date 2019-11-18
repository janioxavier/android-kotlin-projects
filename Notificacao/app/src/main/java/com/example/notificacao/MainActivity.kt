package com.example.notificacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple.setOnClickListener {
            NotificationUtils.notificationSimple(this, "Texto da notificação pelo botão")
        }

        btn_action.setOnClickListener {
            NotificationUtils.notificationWithAction<Any?>(this, "Texto da notificação com ação")
        }

        btn_bigText.setOnClickListener {
            NotificationUtils.notificationBigText(this)
        }

        btn_ultima.setOnClickListener {
            NotificationUtils.notificationWithButtonAction(this, "Notificação com Botão")
        }
    }
}
