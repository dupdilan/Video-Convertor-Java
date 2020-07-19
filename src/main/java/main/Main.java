package main;

import org.apache.log4j.BasicConfigurator;

public class Main {

    public static void main(String[] args) {

        BasicConfigurator.configure();

        AllocatorThread assingThread = AllocatorThread.getInstance();

        assingThread.threadAssigner();



    }
}
