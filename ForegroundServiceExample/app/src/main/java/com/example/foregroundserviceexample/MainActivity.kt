package com.example.foregroundserviceexample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun generateNotification(view: View){
        val ChannelID : String = "Test"
        val ChannelName : String = "Android"

        //1 - Create notification manager's object
        val manager : NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        //2 - Building a notification
        val builder : NotificationCompat.Builder = NotificationCompat.Builder(this,ChannelID)
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle("Test Notification")
                .setContentText("This is a testing notification")

        val notification : Notification = builder.build()

        //3 - Create a Notification Channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel : NotificationChannel =
                NotificationChannel(ChannelID,ChannelName,NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(notificationChannel)
        }

        //4 - Show the notification
        manager.notify(123,notification)

    }
}