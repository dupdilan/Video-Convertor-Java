package main;

import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.nio.file.*;

public class FileListner {

    public static void main(String[] args) {

        BasicConfigurator.configure();

        FileListner watch = new FileListner();
        watch.threadAssigner();

    }

    public void threadAssigner() {

        Runnable thread1 = () -> {
            try {
                check_mp4TOmp3();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(thread1);
        t1.start();

    }


    //method
    private void check_mp4TOmp3() throws IOException, InterruptedException {

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

}
