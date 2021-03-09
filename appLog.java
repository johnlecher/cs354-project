import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class appLog {

		
public static void main(String[] args) {    
	String fileLoc = "FILE LOCATION HERE";
	try (BufferedReader br = new BufferedReader(new FileReader(fileLoc))){ // add log here
		
		BufferedWriter out = new BufferedWriter(new FileWriter("src/ApplicationLog.csv"));
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
	
	try(BufferedReader br = new BufferedReader(new FileReader("src/ApplicationLog.csv"))) {
		
		String strLine = br.readLine();
		strLine = br.readLine(); // read log line by line
		int line = 2;
        String[] strSplit;
        while(strLine != null) {
        	strSplit = strLine.split(",");
        	if(strSplit[4].equalsIgnoreCase("EMPTY")) {
        		System.out.println("Error located in log line: " + line);
        	}
        	strLine = br.readLine();
        	line++;
        }
	} catch (IOException e) {
		e.printStackTrace();
		}
	}
}
