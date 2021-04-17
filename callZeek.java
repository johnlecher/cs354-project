import java.io.BufferedReader;
import java.io.InputStreamReader;

public class callZeek {
    public static void main(String[] args)
   {
    String s;
    Process p;
    try {
        p = Runtime.getRuntime().exec("./callZeek.sh");
        BufferedReader br = new BufferedReader(
            new InputStreamReader(p.getInputStream()));
        while ((s = br.readLine()) != null)
            System.out.println(s);
        p.waitFor();
        System.out.println ("exit: " + p.exitValue());
        p.destroy();
    } catch (Exception e) {System.out.println(e);}
   } 
}
