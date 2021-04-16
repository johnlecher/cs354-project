import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class printUsage {
    public static void main(String[] args) {
    File cDrive = new File("C:");
    
    System.out.println(String.format("Total space: %.2f GB", (double)cDrive.getTotalSpace() /1073741824));
    System.out.println(String.format("Free space: %.2f GB", (double)cDrive.getFreeSpace() /1073741824));
    System.out.println(String.format("Usable space: %.2f GB", (double)cDrive.getUsableSpace() /1073741824));

    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

for(Long threadID : threadMXBean.getAllThreadIds()) {
    ThreadInfo info = threadMXBean.getThreadInfo(threadID);
    System.out.println("Thread name: " + info.getThreadName());
    System.out.println("Thread State: " + info.getThreadState());
    System.out.println(String.format("CPU time: %s ns", 
      threadMXBean.getThreadCpuTime(threadID)));
  }
}

}