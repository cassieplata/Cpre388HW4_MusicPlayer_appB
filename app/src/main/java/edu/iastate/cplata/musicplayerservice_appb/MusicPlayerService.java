package edu.iastate.cplata.musicplayerservice_appb;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import java.util.ArrayList;
import android.content.ContentUris;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.PowerManager;
import android.util.Log;

public class MusicPlayerService extends Service implements MediaPlayer.OnPreparedListener,
MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    private static final String NOTIFICATION_CHANNEL = "Music Playing";
    private static final int NOTIFICATION_ID = 1;
    private MediaPlayer mediaPlayer;
    //private ArrayList<Song> songs;
    private int songPosn;

    public MusicPlayerService(){

    }

    public static void startAction(Context context){
        Intent intent = new Intent(context, MusicPlayerService.class);
        context.startService(intent);
    }

    public static void stopAction(Context context){
        Intent intent = new Intent(context, MusicPlayerService.class);
        context.stopService(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //Creating Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL);
        builder
                .setContentTitle("Music Player")
                .setContentText("You are playing a song right now");

        //Make service a foreground service
        startForeground(NOTIFICATION_ID, builder.build());

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Called when the end of a media source is reached during playback.
     *
     * @param mp the MediaPlayer that reached the end of the file
     */
    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    /**
     *
     * @param mp
     * @param what
     * @param extra
     * @return
     */
    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    /**
     * Called when the media file is ready for playback.
     *
     * @param mp the MediaPlayer that is ready for playback
     */
    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}

