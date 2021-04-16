import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class dataAgg2 {

	public static void main(String[] args) {
		
		ArrayList<String> logs = new ArrayList<String>();
		logs.add("src/log.csv");
		logs.add("src/ApplicationLog.csv");
		System.out.println("Library: " + logs.toString());
		Scanner fileScan = new Scanner(System.in);
		String loc;
		do {
			System.out.print("\nEnter a file location of a log that needs to be added to the library (else enter 'x'): ");
			loc = fileScan.next();
			if(loc.equalsIgnoreCase("x"))
				break;
			logs.add(loc);
			System.out.println("\nLibrary: " + logs.toString());
		} while(loc != "");
		
		System.out.print("\n\nEnter the index of which file to search: ");
		int i1 = fileScan.nextInt();
		
		String location = logs.get(i1);
		
		try(BufferedReader br = new BufferedReader(new FileReader(location))) {
			
			String strLine = br.readLine();
			strLine = br.readLine(); // read log line by line
			int line = 2;
	        String[] strSplit;
	        System.out.print("Enter what term to search for: ");
	        String search = fileScan.next();
	        System.out.println("Searching for: " + "[" +search+ "]");
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
		fileScan.close();
	}
}
