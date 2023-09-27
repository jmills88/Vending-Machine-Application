package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Logger {
    private final String EVENT_FORMATTER = "%1$s %2$s";

    private File logFile;
    private static final String DEFAULT_LOG_FILE = "Log.txt";

    public Logger(){
        logFile = new File(DEFAULT_LOG_FILE);
    }
    public void write(String event){
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(logFile,true))){
            String formattedEvent = String.format(EVENT_FORMATTER, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).toString(), event);
            writer.write(formattedEvent + "\n");
        }catch(FileNotFoundException fnfe){
            System.out.println("File Not Found: T-Virus detected");
        }catch (Exception ex){
            System.out.println("System error: The T-Virus has been released");
        }
    }
}









