import java.util.*;

public class statDetection {
	
	public static void main (String[] args)
	{
		Random random = new Random();
		List<Double> list = new LinkedList<>();
		
		for (int i=0; i < 50; i++) {
			double num = random.nextGaussian()*1+10; //mean=10, sd=1
			list.add(i, num);
		}
		for (int i=50; i < 100; i++) {
			double num = random.nextGaussian()*10+50; //mean=50, sd=10
			list.add(i, num);
		}
		
		System.out.println(list);		
	}
	
}
