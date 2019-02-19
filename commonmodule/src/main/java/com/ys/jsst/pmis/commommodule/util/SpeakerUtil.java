package com.ys.jsst.pmis.commommodule.util;

import android.content.Context;
import android.media.AudioManager;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-7-20 13:55
 */
public class SpeakerUtil {
    private static int currVolume;

    public static void OpenSpeaker(Context context) {

        try{
            AudioManager audioManager = (AudioManager) context.getSystemService  (Context.AUDIO_SERVICE);
            //audioManager.setMode(AudioManager.ROUTE_SPEAKER);
            audioManager.setMode(AudioManager.MODE_IN_CALL);
            currVolume = audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);

            if(!audioManager.isSpeakerphoneOn()) {
                audioManager.setSpeakerphoneOn(true);

                audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL,
                        audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL ),
                        AudioManager.STREAM_VOICE_CALL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //关闭扬声器
    public static void CloseSpeaker(Context context) {

        try {
            AudioManager audioManager = (AudioManager) context.getSystemService     (Context.AUDIO_SERVICE);
            if(audioManager != null) {
                if(audioManager.isSpeakerphoneOn()) {
                    audioManager.setSpeakerphoneOn(false);
                    audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL,currVolume,
                            AudioManager.STREAM_VOICE_CALL);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Toast.makeText(context,"扬声器已经关闭",Toast.LENGTH_SHORT).show();
    }
}
