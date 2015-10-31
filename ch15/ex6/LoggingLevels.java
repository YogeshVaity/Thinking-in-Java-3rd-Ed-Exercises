//: c15:LoggingLevels.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import com.bruceeckel.simpletest.*;
import java.util.logging.*;
import java.io.*;

public class LoggingLevels {
  private static Test monitor = new Test();
  private static Logger
    lgr = Logger.getLogger("com"),
    lgr2 = Logger.getLogger("com.bruceeckel"),
    util = Logger.getLogger("com.bruceeckel.util"),
    test = Logger.getLogger("com.bruceeckel.test"),
    rand = Logger.getLogger("random");
  private static void logMessages() {
    try {
      FileHandler handler = new FileHandler("LogToFile.txt");
      handler.setFormatter(new SimpleFormatter());
      lgr.addHandler(handler);
    } catch(IOException e) {
      throw new RuntimeException(e);
    }    
    lgr.info("com : info");
    lgr2.info("com.bruceeckel : info");
    util.info("util : info");
    test.severe("test : severe");
    rand.info("random : info");
  }
  public static void main(String[] args) {
    lgr.setLevel(Level.SEVERE);
    System.out.println("com level: SEVERE");
    logMessages();
    util.setLevel(Level.FINEST);
    test.setLevel(Level.FINEST);
    rand.setLevel(Level.FINEST);
    System.out.println("individual loggers set to FINEST");
    logMessages();
    lgr.setLevel(Level.SEVERE);
    System.out.println("com level: SEVERE");
    logMessages();
  }
} ///:~
