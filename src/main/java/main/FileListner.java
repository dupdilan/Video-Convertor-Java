package main;

import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.nio.file.*;

public class FileListner {

    public void check_mp4TOmp3() throws IOException, InterruptedException {

        Path faxFolder = Paths.get("D:\\media\\mp4Tomp3");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        boolean valid = true;
        do {
            WatchKey watchKey = watchService.take();

            for (WatchEvent event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString();

                    //if the newly added file extension is .mp4 encode() is called
                    if ( fileName.toString().endsWith(".mp4")){
                        System.out.println("New File Added : " + fileName);

                        Converter mp3 =new Converter();
                        mp3.mp4TOmp3(fileName);


                    } else {
                        System.out.println("File created in valid : " + fileName+" is a not supported file format");
                    }

                }
            }
            valid = watchKey.reset();

        } while (valid);

    }
    //public void  check_Mp4(){
      //  System.out.println("Thread 2 working");
      //}

    public void check_Mp4ToMkv() throws IOException, InterruptedException {

        Path faxFolder = Paths.get("D:\\media\\mp4tomkv");

        WatchService watchService = FileSystems.getDefault().newWatchService();
        faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        //System.out.println("Thread 2 working");
        boolean valid = true;
        do {
            WatchKey watchKey = watchService.take();

            for (WatchEvent event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();

                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString();

                    //check the newly added file type support or not support.. only mp4 support
                    if ( fileName.toString().endsWith(".mp4")){
                        System.out.println("New File Added : " + fileName);
                    //create object of Converter class and call mkv converting method
                        Converter mkv =new Converter();
                        mkv.mp4toMKV(fileName);


                    } else {
                        System.out.println("File  : " + fileName+" is a not supported. File type is not mp4");
                    }

                }
            }
            valid = watchKey.reset();

        } while (valid);

    }

    //mp4toflv
    //checks wheather new mp4 is added to mp4TOflv file
    public void check_mp4TOflv() throws IOException, InterruptedException {

        Path faxFolder = Paths.get("D:\\media\\mp4Toflv");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        boolean valid = true;
        do {
            WatchKey watchKey = watchService.take();

            for (WatchEvent event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString();

                    //if the newly added file extension is .mp4 encode() is called
                    if ( fileName.toString().endsWith(".mp4")){
                        System.out.println("New File Added : " + fileName);

                        Converter flv =new Converter();
                        flv.mp4Toflv(fileName);

                    } else {
                        System.out.println("File created in valid : " + fileName+" is a not supported file format");
                    }

                }
            }
            valid = watchKey.reset();

        } while (valid);

    }


}
