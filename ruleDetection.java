import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;


public class ruleDetection {
public static void main(String[] args) throws FileNotFoundException, IOException {
	try(BufferedReader log = new BufferedReader(new FileReader("src/sysLog.txt"))){
		BufferedReader rule = new BufferedReader(new FileReader("src/rules.txt"));
	
		String strLine = log.readLine(); // read log line by line 
		String strLine2 = rule.readLine(); // read log line by line
		int lineCount = 1;
		
        while (strLine != null) {
        	
        	//while (strLine2 != null) {
            if (strLine.contains(strLine2)) {
            	JOptionPane.showMessageDialog(null, "Alert found on line: "+ lineCount);

            }
        //	}
                
            lineCount++;
            strLine = log.readLine();            
            }
        
        log.close();
        rule.close();
        

	}
}

}
