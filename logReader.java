package intru;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class logReader {
	
		
public static void main(String[] args) {    
	try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\quinn\\OneDrive\\Desktop\\Samba File Server Log.csv"))){ // add log here
		 
		BufferedWriter out = new BufferedWriter(new FileWriter("apeandedLog.log")); // Changer log to what we want to be recorded
		   
		   String strLine;

		   // read log line by line
		   while ((strLine = br.readLine()) != null)   {	
			   String[] split = strLine.split(",");
			   
		     // parse strLine to obtain what you want
		     System.out.print(split[0] + " ");		     
		     
		     out.write(split[0]+ " ");
		     		     

		   }
		  out.close();
		   
		} catch (IOException e) {
		      e.printStackTrace();
		  }
	
}
}
