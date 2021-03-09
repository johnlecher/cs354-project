
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {
	public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException { 
		try (BufferedReader br = new BufferedReader(new FileReader("src/SystemLog.csv"))){
			BufferedWriter out = new BufferedWriter(new FileWriter("src/hashed.csv"));			
			
			String strLine;
			
			
			
			while ((strLine = br.readLine()) != null)   {	
				
		        MessageDigest md = MessageDigest.getInstance("SHA-256");
		        byte[] digest = md.digest(strLine.getBytes(StandardCharsets.UTF_8));
		        
		        
		        String hex = String.valueOf(digest);
		        
		        // print SHA-256 Message Digest		        
		        out.write(toHex(hex) + ",\n");
		        
		        
		}
			out.close();
		
		
		
	}
}
	public static String toHex(String arg) {    //converts string into HEX 
        return String.format("%040x", new BigInteger(1, arg.getBytes()));
    }
}
