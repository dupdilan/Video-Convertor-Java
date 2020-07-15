package main;

import com.sun.org.apache.bcel.internal.Repository;
import org.apache.log4j.BasicConfigurator;
import ws.schild.jave.*;
import java.util.Scanner;
import java.io.File;


public class Converter {

    public static void main(String[] args){

        BasicConfigurator.configure();

        BasicConfigurator.configure();
        Converter convert = new Converter();
        convert.mp4TOmp3();

    }


    public void mp4TOmp3(){

        try {
            File source = new File("C:\\Users\\dupdilan\\Desktop\\media");
            File target = new File("C:\\Users\\dupdilan\\Desktop\\media-converted");

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



}
