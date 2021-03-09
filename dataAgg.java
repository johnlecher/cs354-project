import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class dataAgg {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("src/ApplicationLog.csv"))) {
			
			String strLine = br.readLine();
			strLine = br.readLine(); // read log line by line
			int line = 2;
	        String[] strSplit;
	        Scanner term = new Scanner(System.in);
	        System.out.print("Enter what term to search for: ");
	        String search = term.nextLine();
	        System.out.println("Searching for: " + "[" +search+ "}");
	        while(strLine != null) {
	        	strSplit = strLine.split(",");
	        	for(int j = 0; j<strSplit.length; j++) {
	        		if(strSplit[j].equalsIgnoreCase(search)) {
		        		System.out.println("Error located in log line " + line + " and column " + (j+1));
		        	}
	        	}
	        	strLine = br.readLine();
	        	line++;
	        }
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
}
