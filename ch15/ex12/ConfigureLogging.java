/* Modify log.prop to add an additional initialization class that 
 * initializes a custom Formatter for the logger com.
 */
// Imp Note : CustomFormatter.java must be compiled first
// to get it's .class file

import com.bruceeckel.simpletest.*;
import java.util.logging.*;

public class ConfigureLogging {
  private static Test monitor = new Test();
  static Logger lgr = Logger.getLogger("com"),
    lgr2 = Logger.getLogger("com.bruceeckel"),
    util = Logger.getLogger("com.bruceeckel.util"),
    test = Logger.getLogger("com.bruceeckel.test"),
    rand = Logger.getLogger("random");
  public ConfigureLogging() {
    /* Set Additional formatters, Filters and Handlers for
       the loggers here. You cannot specify the Handlers
       for loggers except the root logger from the
       configuration file. */
  }
  public static void main(String[] args) {
    sendLogMessages(lgr);
    sendLogMessages(lgr2);
    sendLogMessages(util);
    sendLogMessages(test);
    sendLogMessages(rand);
  }
  private static void sendLogMessages(Logger logger) {
    System.out.println(" Logger Name : "
      + logger.getName() + " Level: " + logger.getLevel());
    logger.finest("Finest");
    logger.finer("Finer");
    logger.fine("Fine");
    logger.config("Config");
    logger.info("Info");
    logger.warning("Warning");
    logger.severe("Severe");
  }
}
