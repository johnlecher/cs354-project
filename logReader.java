package intru;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class logReader {

		
public static void main(String[] args) {    
	try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\quinn\\OneDrive\\Desktop\\sysLog.log.txt"))){ // add log here
		 
		BufferedWriter out = new BufferedWriter(new FileWriter("SystemLog.csv")); // Changer log to what we want to be recorded
		   
		   String strLine;

		   // read log line by line
		   while ((strLine = br.readLine()) != null)   {				   
			   
			   String csv = strLine.replace(",", ";"); 
			   
		     // parse strLine to obtain what you want		     
		     out.write(csv + ",\n");
		     		     

		   }
		  out.close();
		   
		} catch (IOException e) {
		      e.printStackTrace();
		  }
	
}
}
