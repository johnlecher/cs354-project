import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging;


public class filterLog {

    public static void main(String[] args, char Logger, char applicationLog){
        
        Logger log = LogManager.getLogger();

        ApplicationLog applicationlog = new ApplicationLog();
        
        log.info("Do not log information: ", applicationLog);
        log.info("Log information. ");


    }
    
}
