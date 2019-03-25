package DiskUsage;

import java.io.File;

public class DiskUsage {

   private static final String pathname = "C:\\Users\\Gorm-Erik\\Desktop\\movieroll";
   private static final File file = new File(pathname);
   private static int sum = 0;
   
    public static void main(String[] args) {
        du(file);
        System.out.println("The total size of the files is: " + sum);
    }
    
    public static int du(File file)  {
        
        
        if (file.isDirectory()) {
          for (File fil : file.listFiles())   {
             
              if (fil.isFile()) {
                  
                  sum += fil.length();
              }
              else if (fil.isDirectory())   {
                  
                  du(fil);
              }
           }
        }
        
        return sum;
        
        }
    
}
