package com.example.a501_10.pushmessageexample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by 501-10 on 2018-03-21.
 */

public class MyFirebaseMessagingService extends FirebaseInstanceIdService{


    public void onMessageReceived(RemoteMessage remoteMessage) {
        showNotification(remoteMessage.getData().get("title"),
                remoteMessage.getData().get("message"));

    }

    private void showNotification(String titile, String message){
        //푸쉬 메시지를 눌렀을때 실행하는 Activity를 지정하는 인텐트를 만듬
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //앱이 실행되어 있지 않은 경우에 메시지를 받아 처리할 수 있는 pendingIntent 객체를 만듬
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,
                intent, PendingIntent.FLAG_ONE_SHOT);

        //메시지를 수신했을때 소리알림을 표시하기 위한 defaultSoundUri 객체 생성
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(
                RingtoneManager.TYPE_NOTIFICATION);
        //메시지를 표현 하기 위한 설정
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher) //아이콘 설정
                .setContentTitle(titile) // 제목 설정
                .setContentText(message)  // 메시지 내용 설정
                .setSound(defaultSoundUri) //알림 메시지 소리
                .setAutoCancel(true) //푸쉬 메시지를 터치하였을때 메시지를 지움
                .setContentIntent(pendingIntent);  //pending intent 설정

        //수신한 메시지를 스마트폰에서 알림
        NotificationManager manager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }
}
