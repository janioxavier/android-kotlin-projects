package com.example.notificacao

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationUtils {

    val CHANNEL_ID = "default"

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(ctx: Context) {
        val notificationManager =
            ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelName = "Padrão"
        val channelDescription = "Canal de Notificações"

        val channel = NotificationChannel(
            CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = channelDescription
            enableLights(true)
            lightColor = Color.GREEN
            enableVibration(true)
        }

        notificationManager.createNotificationChannel(channel)
    }

    fun notificationSimple(ctx: Context, txt: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(ctx)
        }

        val notificationBuilder = NotificationCompat.Builder(ctx, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_favorite)
            .setContentTitle("Notificação Simples")
            .setContentText(txt)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ActivityCompat.getColor(ctx, R.color.colorAccent))
            .setDefaults(Notification.DEFAULT_ALL)

        val notificationManager = NotificationManagerCompat.from(ctx)
        notificationManager.notify(1, notificationBuilder.build())
    }

    fun notificationWithButtonAction(ctx: Context, txt: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(ctx)
        }

        val actionIntent = Intent(ctx, NotificationActionReceiver::class.java).apply {
            putExtra("msg", "Ação da notificação emitida pelo brodcast receiver")
        }

        val pendingIntent = PendingIntent.getBroadcast(ctx,1,actionIntent,0)

        val notificationBuilder = NotificationCompat.Builder(ctx, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_favorite)
            .setContentTitle("Notificação com BroadCast")
            .setContentText(txt)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ActivityCompat.getColor(ctx, R.color.colorAccent))
            .setDefaults(Notification.DEFAULT_ALL)
            .addAction(0, "Ação", pendingIntent)
            .addAction(0, "Ação", pendingIntent)
            .addAction(0, "Ação", pendingIntent)

        val notificationManager = NotificationManagerCompat.from(ctx)

        notificationManager.notify(4, notificationBuilder.build())
    }

    fun notificationBigText(ctx: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(ctx)
        }

        val bigTextStyle = NotificationCompat
            .BigTextStyle()
            .bigText("Este é um exemplo de um texto grande para a minha notificação no exemplo da aula da nuplam e esta sendo apresentada na aula de hoje. Apresentar aos alunos e dizer como fazer")

        val notificationBuilder = NotificationCompat.Builder(ctx, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_favorite)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ActivityCompat.getColor(ctx, R.color.colorAccent))
            .setDefaults(Notification.DEFAULT_ALL)
            .setStyle(bigTextStyle)

        val notificationManager = NotificationManagerCompat.from(ctx)
        notificationManager.notify(3, notificationBuilder.build())
    }

    fun <T : Any?> notificationWithAction(ctx: Context, txt: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(ctx)
        }

        val notificationBuilder = NotificationCompat.Builder(ctx, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_favorite)
            .setContentTitle("Notificação com Ação")
            .setContentText(txt)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ActivityCompat.getColor(ctx, R.color.colorAccent))
            .setContentIntent(getContentIntent(ctx))
            .setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_ALL)

        val notificationManager = NotificationManagerCompat.from(ctx)
        notificationManager.notify(2, notificationBuilder.build())
    }


    private fun getContentIntent(ctx: Context) : PendingIntent {
        val i = Intent(ctx, DetailActivity::class.java).apply {
            putExtra("msg", "Via notificação")
        }
        return PendingIntent.getActivity(ctx, 0, i, 0)
    }

    private fun <T : Any?> getContentIntent(ctx: Context, clazz: Class<T>) : PendingIntent {
        val i = Intent(ctx, clazz).apply {
            putExtra("msg", "Via notificação")
        }
        return PendingIntent.getActivity(ctx, 0, i, 0)
    }
}