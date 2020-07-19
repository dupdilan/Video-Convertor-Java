package main;

import java.io.File;
import java.io.IOException;

public class AllocatorThread {

    private static AllocatorThread instance;

    //creating a private constructor (have to used in Singleton)
    private AllocatorThread() {
    }

    public static AllocatorThread getInstance(){
        if(instance == null ){
            instance = new AllocatorThread();
        }
        return instance;
    }

    public void threadAssigner() {

        Runnable thread1 = () -> {
            try {
                FileListner mp3 = new FileListner();
                mp3.check_mp4TOmp3();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable thread2 = () -> {
            try {
                FileListner flv = new FileListner();
                flv.check_mp4TOflv();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable thread3 = () -> {
            try {
                FileListner mkv = new FileListner();
                mkv.check_Mp4ToMkv();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t3 = new Thread(thread3);
        t3.start();

        Thread th1 = new Thread(thread1);
        th1.start();

        Thread t2 = new Thread(thread2);
        t2.start();
    }



}
