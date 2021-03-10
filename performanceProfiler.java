import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class performanceProfiler {
   public static void main(String[] args)
   {
    String s;
    Process p;
    try {
        p = Runtime.getRuntime().exec("./performanceProfiler.sh");
        BufferedReader br = new BufferedReader(
            new InputStreamReader(p.getInputStream()));
            BufferedWriter out = new BufferedWriter(new FileWriter("src/systemPerformance.csv"));
        while ((s = br.readLine()) != null)
            out.write(s + "\n");
        p.waitFor();
        out.close();
        System.out.println ("exit: " + p.exitValue());
        p.destroy();
    } catch (Exception e) {System.out.println(e);}
   } 
}
