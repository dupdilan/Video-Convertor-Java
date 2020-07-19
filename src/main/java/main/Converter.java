package main;

import com.sun.org.apache.bcel.internal.Repository;
import org.apache.log4j.BasicConfigurator;
import ws.schild.jave.*;
import java.util.Scanner;
import java.io.File;


public class Converter {

    public void mp4TOmp3(String name){

        try {
            File source = new File("D:\\media\\mp4Tomp3\\"+name);
            File target = new File("D:\\media-converted\\mp4Tomp3-converted\\"+name+".mp3");

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(128000);
            audio.setChannels(2);
            audio.setSamplingRate(44100);

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("mp3");
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            //ex.printStackTrace();
            boolean succeeded = false;
        }

    }
    //Converting mp4toflv method
    public void  mp4Toflv(String name){

        try{
            File source = new File("D:\\media\\mp4Toflv\\"+name);
            File target = new File("D:\\media-converted\\mp4Toflv-converted\\"+name+".flv");

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));

            //video Attributes
            VideoAttributes video = new VideoAttributes();
            video.setCodec("flv");
            video.setBitRate(new Integer(160000));
            video.setFrameRate(new Integer(15));
            video.setSize(new VideoSize(400, 300));

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("flv");
            attrs.setAudioAttributes(audio);
            attrs.setVideoAttributes(video);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        }catch (Exception ex){
            boolean succeeded = false;
        }
    }

    //converting method mp4 file to mkv
    public void mp4toMKV(String name){

        try {
            File source = new File("D:\\media\\mp4tomkv\\"+name);
            File target = new File("D:\\media-converted\\mp4tomkv-converted\\"+name+".mkv");

            // convert the Audio parts
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));

            //convert the Vedio parts
            VideoAttributes video = new VideoAttributes();
            video.setCodec("mpeg4");
            video.setBitRate(new Integer(160000));
            video.setFrameRate(new Integer(15));
            video.setSize(new VideoSize(400, 300));

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("matroska");
            attrs.setAudioAttributes(audio);
            attrs.setVideoAttributes(video);

            //Encordr method
            Encoder encoder = new Encoder();

            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            boolean succeeded = false;
        }

    }

    public void  mp4Toflv(String name){

        try{
            File source = new File("D:\\media\\mp4Toflv\\"+name);
            File target = new File("D:\\media-converted\\mp4Toflv-converted\\"+name+".flv");

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));

            //video Attributes
            VideoAttributes video = new VideoAttributes();
            video.setCodec("flv");
            video.setBitRate(new Integer(160000));
            video.setFrameRate(new Integer(15));
            video.setSize(new VideoSize(400, 300));

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("flv");
            attrs.setAudioAttributes(audio);
            attrs.setVideoAttributes(video);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        }catch (Exception ex){
            boolean succeeded = false;
        }
    }



}
