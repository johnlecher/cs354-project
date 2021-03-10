import java.util.*;

public class statDetection2 {
	
	public static void main (String[] args)
	{
		float[] listA = new float[50];
		float[] listB = new float[50];
		float[] bothLists = randomLists(listA, listB);
		deviatonAlert(bothLists, 10, 3);
	}
	
	static float[] randomLists(float[] list1, float[] list2) { //creates and appends two random distributed float[] arrays
		Random random = new Random();
		for (int i=0; i < list1.length; i++) {
			float num = (float) random.nextGaussian()*1+10; //generate random numbers (normal distribution) with mean= 10 and a sd = 1
			list1[i] = num;
		}
		for (int i=0; i < list2.length; i++) {
			float num = (float) (random.nextGaussian()*10+50); //generate a random numbers (normal distribution) with mean= 50 and a sd = 10
			list2[i] = num;
		}
		
		float[] both = Arrays.copyOf(list1, list1.length+list2.length); //append both lists of numbers as your input
	    System.arraycopy(list2, 0, both, list1.length, list2.length);
		System.out.println(Arrays.toString(both));
		return both;
	}
	
	//alerts for deviation if data is above threshold (passed as argument) and what sliding window that data lies in
	  static void deviatonAlert(float[] list, int windowSize, int threshold) {
		  float tempAvgSD= 0;
		  float movingAvgSD = 0;
		  int baseWindow = 10;
		  int windowCount = 0;
		  
		  double window[] = new double[list.length]; 
		  double temp[] = new double[list.length];
		  for (int i = 0; i < baseWindow; i++) //this is the baseline window (burn in period)
		  {
			  temp[i] = list[i];
		  }
		 
		  movingAvgSD = (float) calculateSD(temp); //moving average SD changes throughout the distribution
		  
		  for (int i = baseWindow; i < list.length; i++) 
		  {
			  windowCount+=windowSize;
			  for (int j = 0; j < windowSize; j++) //gather data into array from specified window size
			  {
					window[i] = list[i];
			  }
			  tempAvgSD = (float) calculateSD(window); //calculate SD from that window
				
			  if (Math.abs(tempAvgSD-movingAvgSD) > threshold) {
					 System.out.println("Alert: Window " + windowCount + ": SD exceeds Threshold: " + threshold + ": SD = " + tempAvgSD);
					 movingAvgSD = tempAvgSD;
			  }
		  }
	  }
	  
	  public static double calculateSD(double numArray[]) //calculates SD of array (used to get SD of movingAvgSD and tempAvgSD) 
	    {
	        double sum = 0.0, standardDeviation = 0.0;
	        int length = numArray.length;

	        for(double num : numArray) {
	            sum += num;
	        }

	        double mean = sum/length;

	        for(double num: numArray) {
	            standardDeviation += Math.pow(num - mean, 2);
	        }

	        return Math.sqrt(standardDeviation/length);
	    }
}
