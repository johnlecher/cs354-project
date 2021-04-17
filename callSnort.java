import java.io.BufferedReader;
import java.io.InputStreamReader;

public class callSnort {
    public static void main(String[] args)
   {
    String s;
    Process p;
    try {
        p = Runtime.getRuntime().exec("./callSnort.sh");
        boolean warningFound = false;
        BufferedReader br = new BufferedReader(
            new InputStreamReader(p.getInputStream()));
        while (warningFound == false)
        {
            s = br.readLine();
            if(s.contains("WARNING"))
            {
                System.out.println(s);
                warningFound = true;
            }
            else
                System.out.println(s);
        }
        p.waitFor();
        System.out.println ("exit: " + p.exitValue());
        p.destroy();
    } catch (Exception e) {System.out.println(e);}
   } 
}