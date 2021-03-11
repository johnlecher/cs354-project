import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class logReader2 {

public static void main(String[] args) {    
    String fileLoc = "src/ApplicationLog.csv"; //Enter log file location
    try (BufferedReader br = new BufferedReader(new FileReader(fileLoc))){
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	String time = timestamp.toString();
    	BufferedWriter out = new BufferedWriter(new FileWriter("src/SystemLog" + time + ".csv"));
        String strLine = br.readLine(); // read log line by line 
        String[] strSplit;
        while (strLine != null) {
            strSplit = strLine.split(",");
            for(int i = 0; i<strSplit.length; i++) {
                out.write(strSplit[i]+",");
                }
            out.write("\n");
            strLine = br.readLine();
            }
        out.close();
           
        } catch (IOException e) {
              e.printStackTrace();
        }
	}
}
